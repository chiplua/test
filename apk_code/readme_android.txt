1.使用Bundle传递参数 源Activity中：MainActivity.java 使用Bundle传递参数到另一个Activity(http://wiki.eoe.cn/page/Starting_Another_Activity.html)


2.重载与重构的区别:
Overload和Override的区别。Overloaded的方法是否可以改变返回值的类型?
方法的重写Overriding和重载Overloading是Java多态性的不同表现。重写Overriding是父类与子类之间多态性的一种表现，重载Overloading是一个类中多态性的一种表现。如果在子类中定义某方法与其父类有相同的名称和参数，我们说该方法被重写 (Overriding)。子类的对象使用这个方法时，将调用子类中的定义，对它而言，父类中的定义如同被"屏蔽"了。如果在一个类中定义了多个同名的方法，它们或有不同的参数个数或有不同的参数类型，则称为方法的重载(Overloading)。Overloaded的方法是可以改变返回值的类型。


3.android布局介绍和TextView的引入（初级安卓）
一、布局的介绍：【了解】
1、一共有五种布局，都是ViewGroup的子类。分别是
①AbsoluteLayout、
②RelativeLayout,
③LinearLayout,
④FrameLayout,
⑤TableLayout.
而TableLayout是LinearLayout的子类。（中文分别是：绝对布局、相对布局、线性布局、帧布局、表格布局）
2、在2.2操作系统中将AbsoluteLayout过期。而目前FrameLayout、TableLayout也逐
渐被过去。只推荐使用RelativeLayout、LinearLayout两种布局
二、LinearLayout：【掌握】
（一）、概念：
1，线性布局控制其中的控件或组件横向或纵向排列。
2，在线性布局布局中，每一行或每一列只能放一个控件。
3，线性布局不会换行。当控件排列到窗体边缘，后面的控件就被隐藏，而不会显示出来。
4，线性布局的默认方向是水平方向（Horizontal）。*/
（二）、属性：
1.android:orientation   
定义布局内控件或组件的排列方式
可选项：vertical 、 horizontal
2.android:width   
定义控件的宽度
可选项：fill_parent / match_parent/ wrap_content
备注：fill_parent / match_parent的效果完全一致，都是填充整个父控件。
但是自2.2版本开始推荐使用match_parent 。wrap_content指的是该控件的宽度正好包裹内容物。
3.android:height   
 定义控件的高度
可选项：fill_parent / match_parent/ wrap_content
4.android:layout_id   
设置控件的id。这样就可以在R.java中自动生成相应的值，在程序中通过findViewById就可以调用。设置id的格式为：android:id = “@+id/id的名字”
5.android:background
设置控件的背景颜色或背景图片
例如：android:background=”#ffffff”
          android:background=”@drawable/图片名称”
【备注：】
颜色有RGB颜色格式和ARGB格式。RGB是红绿蓝三原色。而ARGB是带alpha的三原色，即
有透明度的三原色。
#FFFFFF 代表白色
#000000  黑色
#FFFFFFFF   完全不透明
#00FFFFFF   完全透明
#88FFFFFF   半透明
6.android:layout_weight    
设置控件的权重。即各控件在水平或者垂直方向上平均分配。
备注：如果是水平方向设置权重，要将android:layout_width设置为0dp，如果是垂直
方向上使用权重，要将android:layout_height设置为0dp。否则权重容易受到高度或
宽度的干扰而出现偏差。
7.android:gravity   
该属性用来控制该View的内容物的位置。
如果该属性是定义在布局节点中，则该布局中所有控件的位置都受到这个属性的控制。
如果该属性出现在Button、TextView、EditText等控件中，则用来控制这些控件上的文字的位置。
可选项有：top、bottom、left、right、center_vertical、fill_vertical 、 center、fill等等。
【备注：】本属性与android:layout_gravity不同。
8.android:layout_gravity   设置控件的重心。即控件在布局内的对齐方式。
android:layout_gravity=”right”
可选项有：top、bottom、left、right、center_vertical、fill_vertical 、 
center、fill等等。
这些可选项中不是适用于每一种布局。
在垂直线性布局中，android:gravity为bottom不起作用；
而水平线性布局中，android:gravity为right不起作用。
【备注：】在有些控件中有android:gravity属性。而本属性是
android:layout_gravity属性。两个属性不同。
三、RelativeLayout：【掌握】
（一）、概念：指按着控件之间的相对位置来进行布局。
（二）、属性：分成三大组。
1.第一组：指兄弟控件之间的相对位置。该组属性的值是另一个控件的id。
layout_toRightOf      该控件在哪个控件的右侧
layout_toLeftOf        该控件在哪个控件的左侧
layout_above             该控件在哪个控件的上侧
layout_below             该控件在哪个控件的下侧
2.第二组：指兄弟控件之间的对齐关系。该组属性的值是另一个控件的id。
layout_alignRight       该控件与哪个控件的右对齐
layout_alignLeft        该控件与哪个控件的左对齐
layout_alignTop        该控件与哪个控件的顶对齐
layout_alignBottom        该控件与哪个控件的底对齐
3.第三组：指控件与父布局之间的对齐关系。该组属性的值是true或者false。
layout_alignParentRight                该控件与父布局控件的右对齐吗？
layout_alignParentLeft                 该控件与父布局控件的左对齐吗？
layout_alignParentTop                 该控件与父布局控件的顶端对齐吗？
layout_alignParentBottom              该控件与父布局控件的底部对齐吗？
layout_centerInParent                    该控件位于父布局控件的中心位置吗？
layout_centerVertical                    该控件位于父布局控件的垂直中心位置吗？
layout_centerHorizontal                该控件位于父布局控件的水平中心位置？
android:paddingTop:			在控件的上方填充
四、TextView   【掌握】
（一）、 概念：
文本框控件 （用于在屏幕上显示文本）。
EditText是TextView的子类，文本编辑框，在屏幕上显示可编辑的文本框。
（二）、属性：
1、andorid:text   设置文本的内容
2、 android:textColor     设置文本的颜色
3、 android:textSize       设置文本的字体大小
4、andorid:height          设置文本的高度，以像素为单位
5、 android:width            设置文本的宽度，以像素为单位
6、 android:inputType     设置文本的类型。例如是普通文本，还是emial，passworid，数字等等。
7、 android:singleLine     设置文本是否是单行显示。


4. Android开发中java 命名规则包的命名
　Java包的名字都是由小写单词组成。但是由于Java面向对象编程的特性，每一名Java程序员都可以编写属于自己的Java包，为了保障每个Java包命名的唯一性，在最新的Java编程规范中，要求程序员在自己定义的包的名称之前加上唯一的前缀。由于互联网上的域名称是不会重复的，所以程序员一般采用自己在互联网上的域名称作为自己程序包的唯一前缀。
　　例如： net.frontfree.javagroup

包划分及命名规则:
java代码：
com.mycompany.util
com.mycompany.myproject
com.mycompany.myproject.util
com.mycompany.myproject.model
com.mycompany.myproject.dao
com.mycompany.myproject.dao.ejb
com.mycompany.myproject.dao.hibernate
com.mycompany.myproject.service
com.mycompany.myproject.service.impl
com.mycompany.myproject.webapp.action
com.mycompany.myproject.webapp.filter
com.mycompany.myproject.webapp.listener
com.mycompany.myproject.webapp.taglib

类的命名
　　类的名字必须由大写字母开头而单词中的其他字母均为小写；如果类名称由多个单词组成，则每个单词的首字母均应为大写例如TestPage；如果类名称中包含单词缩写，则这个所写词的每个字母均应大写，如：XMLExample,还有一点命名技巧就是由于类是设计用来代表对象的，所以在命名类时应尽量选择名词。　　
　　例如： Circle

方法的命名
　　方法的名字的第一个单词应以小写字母作为开头，后面的单词则用大写字母开头。
　　例如： sendMessge

常量的命名
　　常量的名字应该都使用大写字母，并且指出该常量完整含义。如果一个常量名称由多个单词组成，则应该用下划线来分割这些单词。
　　例如： MAX_VALUE

参数的命名
　　参数的命名规范和方法的命名规范相同，而且为了避免阅读程序时造成迷惑，请在尽量保证参数名称为一个单词的情况下使参数的命名尽可能明确。

Javadoc注释
　　Java除了可以采用我们常见的注释方式之外，Java语言规范还定义了一种特殊的注释，也就是我们所说的Javadoc注释，它是用来记录我们代码中的API的。Javadoc注释是一种多行注释，以结束，注释可以包含一些HTML标记符和专门的关键词。使用Javadoc注释的好处是编写的注释可以被自动转为在线文档，省去了单独编写程序文档的麻烦。

   在每个程序的最开始部分，一般都用Javadoc注释对程序的总体描述以及版权信息，之后在主程序中可以为每个类、接口、方法、字段添加Javadoc注释，每个注释的开头部分先用一句话概括该类、接口、方法、字段所完成的功能，这句话应单独占据一行以突出其概括作用，在这句话后面可以跟随更加详细的描述段落。在描述性段落之后还可以跟随一些以Javadoc注释标签开头的特殊段落，例如上面例子中的@auther和@version，这些段落将在生成文档中以特定方式显示。

　　虽然为一个设计低劣的程序添加注释不会使其变成好的程序，但是如果按照编程规范编写程序并且为程序添加良好的注释却可以帮助你编写出设计完美，运行效率高且易于理解的程序，尤其是在多人合作完成同一项目时编程规范就变得更加重要。俗话说“磨刀不误砍柴工”，花费一点时间去适应一下Java编程规范是有好处的。


5.
很多初入Android开发的网友向我们问到Context有什么作用,很多地方都用到它，这里Android123给这些新入门的网友做个简单的解释：
   Context字面意思上下文，位于framework package的android.content.Context中，其实该类为LONG型，类似Win32中的Handle句柄，很多方法需要通过Context才能识别调用者的实例，比如说Toast的第一个参数就是Context，一般在Activity中我们直接用this代替，代表调用者的实例为Activity，而到了一个button的onClick(View view)等方法时，我们用this时就会报错，所以我们可能使用ActivityName.this来解决，主要原因是因为实现Context的类主要有Android特有的几个模型，Activity、Service以及BroadcastReceiver。
  常规需要Context实例的方法主要有各种Service实现的类，比如说SensorManager在实例化时需要getSystemService(String)方法就必须由Context的实例执行，还有一些私有的文件系统I/O比如说openFileInput以及常用的Toast的makeText方法。


6.对某一代码块使用,synchronized后跟括号,括号里是变量,这样,一次只有一个线程进入该代码块.此时,线程获得的是成员锁.例如:

      public int synMethod(int a1){
        synchronized(a1) {
          //一次只能有一个线程进入
        }
      }  


7.Class.forName的作用以及为什么要用它【转】
Class.forName(xxx.xx.xx) 返回的是一个类

首先你要明白在java里面任何class都要装载在虚拟机上才能运行。这句话就是装载类用的(和new 不一样，要分清楚)。

至于什么时候用，你可以考虑一下这个问题，给你一个字符串变量，它代表一个类的包名和类名，你怎么实例化它？只有你提到的这个方法了，不过要再加一点。 
A a = (A)Class.forName("pacage.A").newInstance(); 
这和你 
A a = new A()； 
是一样的效果。

关于补充的问题 
答案是肯定的，jvm会执行静态代码段，你要记住一个概念，静态代码是和class绑定的，class装载成功就表示执行了你的静态代码了。而且以后不会再走这段静态代码了。

Class.forName(xxx.xx.xx) 返回的是一个类 
Class.forName(xxx.xx.xx);的作用是要求JVM查找并加载指定的类，也就是说JVM会执行该类的静态代码段

动态加载和创建Class 对象，比如想根据用户输入的字符串来创建对象 
String str = 用户输入的字符串 
Class t = Class.forName(str); 
t.newInstance();

 在初始化一个类，生成一个实例的时候，newInstance()方法和new关键字除了一个是方法，一个是关键字外，最主要有什么区别？它们的区别在于创建对象的方式不一样，前者是使用类加载机制，后者是创建一个新类。那么为什么会有两种创建对象方式？这主要考虑到软件的可伸缩、可扩展和可重用等软件设计思想。

Java中工厂模式经常使用newInstance()方法来创建对象，因此从为什么要使用工厂模式上可以找到具体答案。 例如： 
class c = Class.forName(“Example”); 
factory = (ExampleInterface)c.newInstance();

其中ExampleInterface是Example的接口，可以写成如下形式： 
String className = "Example"; 
class c = Class.forName(className); 
factory = (ExampleInterface)c.newInstance();

进一步可以写成如下形式： 
String className = readfromXMlConfig;//从xml 配置文件中获得字符串 
class c = Class.forName(className); 
factory = (ExampleInterface)c.newInstance();

上面代码已经不存在Example的类名称，它的优点是，无论Example类怎么变化，上述代码不变，甚至可以更换Example的兄弟类Example2 , Example3 , Example4……，只要他们继承ExampleInterface就可以。

从JVM的角度看，我们使用关键字new创建一个类的时候，这个类可以没有被加载。但是使用newInstance()方法的时候，就必须保证：1、这个类已经加载；2、这个类已经连接了。而完成上面两个步骤的正是Class的静态方法forName()所完成的，这个静态方法调用了启动类加载器，即加载java API的那个加载器。

现在可以看出，newInstance()实际上是把new这个方式分解为两步，即首先调用Class加载方法加载某个类，然后实例化。 这样分步的好处是显而易见的。我们可以在调用class的静态加载方法forName时获得更好的灵活性，提供给了一种降耦的手段。

最后用最简单的描述来区分new关键字和newInstance()方法的区别： 
newInstance: 弱类型。低效率。只能调用无参构造。 
new: 强类型。相对高效。能调用任何public构造。      


7.
程序正常启动(CSR厕所日): onCreate()->onStart()->onResume();   
正常退出(PSD破碎的):     onPause() ->onStop()->onDestory();

一个Activity启动另一个Activity(PS RSR批萨乳酸仁): onPause()->onStop(), 再返回：onRestart()->onStart()->onResume()

程序按back(PSD CSR派送多 次骚扰) 退出： onPause()->onStop()->onDestory(),再进入：onCreate()->onStart()->onResume();
程序按home(PS RSR派送 乳酸仁) 退出： onPause()->onStop(),再进入：onRestart()->onStart()->onResume();


