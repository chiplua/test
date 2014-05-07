1.使用Bundle传递参数 源Activity中：MainActivity.java 使用Bundle传递参数到另一个Activity


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

