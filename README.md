# gitdemo
第二个人修改

##  分支管理
删除服务器远端的分支
    git push origin --delete a</br>
    git push origin --delete  b</br>
    git push origin --delete  c</br>
删除本地的分支</br>
git branch –D a</br>
git branch –D b</br>
git branch –D c</br>
删除git远程仓库里面的文件</br>
1、git rm -rf <文件名></br>
2、git commit -m "for delete"</br>
3、git push -u origin <分支名></br>

查看本地分支列表：</br>
git branch</br>
一：master创建分支a b c</br>
git checkout master</br>
git branch a</br>
git branch b</br>
git branch c</br>
三：修改b的代码</br>
git checkout b</br>
修改代码增加一个类B，并增加方法一</br>
git add B.java</br>
git commit -a</br>
git push -u origin b</br>
四： 1、切换到c，2、修改代码，3、提交，4、合并到master，5、合并到b</br>
git checkout c</br>
修改代码</br>
git commit -a</br>
git push</br>
git checkout master</br>
git merge c</br>
git checkout a</br>
git merge c</br>

五：修改b的代码合并到a</br>
git checkout b</br>
修改代码，在B类上增加方法二</br>
git commit -a</br>
git push</br>
git checkout a</br>
git merge b</br>
git commit -a</br>
git push</br>

六：a合并到master</br>
git checkout master</br>
git merge a</br>
这样看来，至少需要三个分支</br>
七：将B分支上的某个文件或文件夹合并到A分支</br>
1、切换到A分支
$ git checkout A
Switched to branch 'A'
 2、将B分支上的message.html message.css等文件合并到当前分支（A分支）
$ git checkout B message.html message.css message.js other.js
