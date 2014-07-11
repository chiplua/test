git push origin master:origin/master


1.如何去掉注释:
(1).xml中的注意以尖括号之间加感叹号和四个中线为注释
(2).
().
1.如何查看包名和类名:
(1).清空终端显示的内容
(2).插入USB
(3).在终端中输入adb logcat -c && adb logcat（会显示从当前开始的log）回车
(4).点击需要查看的应用的图标
(5).拔出USB
(6).在打印的log中找aaa.bbb.ccc.ddd式样的字符串(大多以com.开头)，比如打开图库的时候抓到的包名和类名分别为:com.android.gallery3d/com.android.camera.CameraLauncher
().
().
().
().
().
().
