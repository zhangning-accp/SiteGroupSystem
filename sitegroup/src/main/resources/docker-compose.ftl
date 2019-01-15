version: '3'

services:
  litecart:
    image: litecart:latest
    ports:
    - ${httpPort}:80

  mysql:
    image: mysql:5.6.40
    environment:
      MYSQL_ROOT_PASSWORD: oopoo1zahChaij9IePhi
      MYSQL_DATABASE: litecart
      MYSQL_USER: litecart
      MYSQL_PASSWORD: diev7Ugh3fushieV1che
      TZ: Asia/Shanghai
    volumes:
      - ${dataPath}:/var/lib/mysql
    command: --character-set-server=utf8mb4 --collation-server=utf8mb4_general_ci --default-time-zone=+8:00 --innodb_buffer_pool_size=5M --innodb_use_native_aio=0
    ports:
    - ${dbPort}:3306