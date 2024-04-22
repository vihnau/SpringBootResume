https://drive.google.com/file/d/1V4vtTZEzxV0pRUfPmk5vFhP1iAYG9mn3/view?usp=drive_link
到google雲端上下載war檔
需求配置:
java jdk 17版本(環境變數更改為17版本的路徑並增加path變數到17版本路徑下的bin(%JAVA_HOME$\bin))
mysql
執行步驟:
1.下載MySQL
2.密碼設定為123456
3.create schema 並名為res
4.命令提示字元cd 到該檔案路徑 並使用語法 java -jar SpringBootResume-0.0.1-SNAPSHOT.war 保持開啟
5.在瀏覽器上http://localhost:8080/res/resume/就可以出現
