# gitdemo
第二个人修改

##  分支管理
删除服务器远端的分支
git push origin --delete a
git push origin --delete  b
git push origin --delete  c
删除本地的分支
git branch –D a
git branch –D b
git branch –D c
删除git远程仓库里面的文件
1、git rm -rf <文件名>
2、git commit -m "for delete"
3、git push -u origin <分支名>

查看本地分支列表：
git branch
一：master创建分支a b c
git checkout master
git branch a
git branch b
git branch c
三：修改b的代码
git checkout b
修改代码增加一个类B，并增加方法一
git add B.java
git commit -a
git push -u origin b
四： 1、切换到c，2、修改代码，3、提交，4、合并到master，5、合并到b
git checkout c
修改代码
git commit -a
git push
git checkout master
git merge c
git checkout a
git merge c

五：修改b的代码合并到a
git checkout b
修改代码，在B类上增加方法二
git commit -a
git push
git checkout a
git merge b
git commit -a
git push

六：a合并到master
git checkout master
git merge a
这样看来，至少需要三个分支，
