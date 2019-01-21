package com.zn.sitegroup.repository;

import com.zn.sitegroup.entity.LcCategoriesEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by zn on 2018/12/13.
 */
public interface ICategoryRepository extends JpaRepository<LcCategoriesEntity,Long> {
    List<LcCategoriesEntity> findByParentId(long parentId);

    /**
     * 获取指定父类下的所有子类信息(向下递归)，返回的结果不包含父类信息
     * @param parentId 父类id
     * @return
     */
    @Query(value="SELECT id FROM (SELECT t1.id,IF(FIND_IN_SET(parent_id, @pids) > 0, @pids\\:= CONCAT(@pids, ',', id), 0) AS ischild " +
            "FROM (SELECT id,parent_id FROM lc_categories as t WHERE t.status = 1 ORDER BY parent_id, id) AS t1,(SELECT @pids\\:=?1) t2) t3 WHERE ischild !=0 ORDER BY id ASC",nativeQuery = true)
    List<Long> findParentAllChildrenId(long parentId);

    /**
     * 获取指定孩子的所有父类，返回的结果已经按由上到下的层级排序(向上递归)。并且包含当前子类信息(位于最底部)
     * @param childId 子类id
     * @return
     */
    @Query(value = "SELECT T2.* FROM (SELECT @r AS _id, (SELECT @r\\:= parent_id FROM lc_categories WHERE id = _id) AS parent_id,@level\\:= @level + 1 AS `level` " +
            "FROM (SELECT @r\\:=?1, @level\\:= 0) AS vars, lc_categories AS h WHERE @r <> 0) T1 JOIN lc_categories AS T2 ON T1._id = T2.id ORDER BY T1.`level` DESC",nativeQuery = true)
    List<LcCategoriesEntity> findChildParents(long childId);
}
