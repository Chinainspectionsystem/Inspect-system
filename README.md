# Inspect-system（pc+android 教务询查系统）


## 项目成员：

@[NewbieProgramer](https://github.com/NewbieProgramer) @[shenzekun](https://github.com/shenzekun) @[vignywang](https://github.com/vignywang) @[yujintumu](https://github.com/yujintumu)

## 项目概述
为督促广大师生认真遵守课堂教学规范，维护正常教学秩序，树立良好的教学教风，提高课堂教学质量，各大高校纷纷出台教务教学巡查制度。但是传统的使用纸质记录巡查报告并交由教务处或相关老师处理的方式，使得对巡查数据的处理比较繁琐，并且不易存储，甚至可能出现还未处理就已丢失的状况。这种传统的方式不仅效率低工作量大，而且无法实现数据的及时更新与分析，所以传统的巡查方式并不能满足现实的巡查需求。

## 需求分析
国家教育体制的进步，和从事教育方面的相关人士不断对教育教学质量要求产生新的认识，促使了全国各大高校开始推行教育教学巡查制度。但是由于缺乏相关技术的支持，传统的巡查方式效率低，很难对收集的数据进行深度的挖掘，并且无法达到教育教学巡查制度的最优效果。为了改变教育教学巡查制度的现状，我们决定开发出一套新的、辅助巡查制度能够达到最优效果的教务教学巡查系统。这套系统将解决现有巡查方式的窘境，能够实现数据的及时存储、提交、更新、分析，并且大大减少人力的劳动量，实现对收集数据最大化的利用

## 运行环境
### 硬件环境
Win10 ,macos, Internet网络 网线等等
### 软件环境
Android端工具: Android studio2.3,SDK8.0

数据库工具: Mysql5.7, Navicat for MySql ,phpMyAdmin

服务器端: Eclipse

前端:HBuilder,VsCode,WebStorm

数据库设计工具:PowerDesigner16 

SVN版本控制工具

浏览器：谷歌浏览器

## 项目设计

**Web端:**

根据权限不同，赋予不同的功能。管理员主要可以对教务系统增删改查，巡查员只可以查看教务系统信息。
管理员和巡查员都可以查看巡查信息，以及巡查结果的可视化展示。

**Android端：**

用户可以完善自己的个人信息，修改密码，修改头像，手势密码。
用户可以获得巡查任务，并根据时间地点得知课堂的基本信息，并根据课堂情况，对该课堂进行巡查打分。也可以通过巡查分析，得到巡查的结果和可视化分析情况。

## 模块功能介绍

**Web端**

1. 登录：实现条件限制的用户登录功能
2. 注册：实现条件限制的用户注册功能。
3. 个人状态：个人信息，修改密码，上传头像，退出
4. 系统管理：实现系统用户、登录信息、用户审核对数据的查询、编辑、删除、批量	删除、选择、全选、每页显示记录数量等操作。（仅管理员操作）
5. 教务管理：教师管理，课程管理，学生管理，部门管理，职称管理，班级	管理
6. 询查管理：询查记录（android 端录入，web 端显示）
7. 询查分析：柱状图，漏斗图，饼状图，精灵图，用可视化的形式对大量数据进行不同类型的分析
8. 联系我们：实现系统介绍、团队介绍、反馈信息等功能

**Android 端：**
1. 登录：实现条件限制的用户登录功能
2. 注册：实现条件限制的用户注册功能
3. 个人中心：手势密码，更换头像，修改密码，检查更新，退出登录
4. 询查：查询课程信息，询查课堂，查看询查记录，询查分析

## 模块结构图

![](http://om8u46rmb.bkt.clouddn.com/web%20%E8%AF%A2%E6%9F%A5%E7%B3%BB%E7%BB%9F%E6%A8%A1%E5%9D%97%E7%BB%93%E6%9E%84%E5%9B%BE.png)

## 程序流程图
![](http://om8u46rmb.bkt.clouddn.com/%E8%AF%A2%E6%9F%A5%E7%B3%BB%E7%BB%9F%E7%A8%8B%E5%BA%8F%E6%B5%81%E7%A8%8B%E5%9B%BE.png)

## 详细设计
* 系统用户 
![](https://ws2.sinaimg.cn/large/006tNc79ly1fhsv7au5nfj30te0caaam.jpg)
* 登录信息
![](https://ws3.sinaimg.cn/large/006tNc79ly1fhsv7tr4qij30u00cndg9.jpg)
* 用户审核
![](https://ws3.sinaimg.cn/large/006tNc79ly1fhsv85b3o0j30uf0dqmxz.jpg)
* 教师管理
![](https://ws2.sinaimg.cn/large/006tNc79ly1fhsv8gwwb3j30wk0e3gmp.jpg)
* 课程管理
![](https://ws4.sinaimg.cn/large/006tNc79ly1fhsv8u099mj31040af750.jpg)
* 学生管理
![](https://ws3.sinaimg.cn/large/006tNc79ly1fhsv95gvt0j31050d0gmu.jpg)
* 部门管理
![](https://ws2.sinaimg.cn/large/006tNc79ly1fhsv9hrh2hj310t0cn0td.jpg)
* 职称管理
![](https://ws3.sinaimg.cn/large/006tNc79ly1fhsv9ugrmvj30py0elq3e.jpg)

