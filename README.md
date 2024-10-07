# 支持DDD和微服务的电子商务平台
这是一个用DDD低代码平台编写的微服务示例代码，演示了名为emall的电子商务平台的开发。

## 如何使用
1) 数据库。在各个微服务中创建mysql数据库，并执行相应的SQL语句创建数据库表结构
2) DDD低代码平台。访问我的仓库`edev-ddd-monolith`中的`edev-ddd-support`模块，用maven制作jar包并install本地仓库
3) 设计文档。业务需求以用例模型`UserCaseModel.md`进行编写，然后编写领域模型`DomainModel.md`
4) 程序设计。详见各模块的测试用例，里面既有业务需求，又有前端的API接口，可以以此了解整个系统基于DDD的设计

## 电子商务平台的业务
本电子商务平台，作为客户与商家相互交易的平台，一边联系的是千千万万需要选购商品的客户，一边联系的是拥有琳琅满目各色商品的商家。
商家通过该平台管理自己的商品，添加员工、上架商品、管理库存；客户通过该平台的注册，可以选购商品、下单、支付，同时也可以进行取消订单、退货等等操作。

客户，为了在该平台选购商品，需要注册、录入个人信息、管理地址信息、建立个人账户。
当然，在下单时，可以选择个人账户、支付宝、微信等多种方式进行支付。
此外，为了获得更多的优惠，客户可以申请成为会员。成为会员以后，每次购买商品可以积分。
积分可以兑换商品，也会根据积分升级会员，享受更大的优惠。

商家，也就是供应商，首先需要添加自己的员工，由员工去管理自己的商品。
然后，员工可以添加商品、上架商品、管理库存，为客户提供商品服务。

除了客户和商家，本平台还需要有管理员来管理平台。
登录到本平台的所有用户，不管是管理员、客户，还是商家的员工，都是以用户的身份注册，然后在注册时赋予不同的角色。
在此基础上，管理员去管理角色、权限，并为不同的用户与角色进行授权。

每个客户都是自己注册用户，授予默认的客户权限；而商家是由管理员进行注册，添加第一个员工，剩下的工作则由商家自己的员工去完成。
平台的管理员是有另一个管理员添加，并赋予相应的权限。此外，管理员还可以添加游客。
游客在初始状态下什么权限都没有，然后再由管理员去给他授权。

最后，有了客户，有了商家，有了商品，客户就可以在本平台下选购商品，下单、支付，完成各自的交易。
在下单还未支付前可以取消订单；完成支付以后也可以选择退货操作。

## 让AI辅助软件开发
随着技术的飞速发展，AI人工智能已经得到了长足的发展，现在AI已经可以辅助程序员参与软件开发。
然而，AI在这个过程中还是一个辅助的角色，要让AI直接根据需求文档开发出我们所需的软件系统，依然是一个不太靠谱的事情。
我们需要将软件研发的过程化整为零，划分成更加细致的不同阶段，让AI一个阶段一个阶段地辅助我们完成各个阶段的工作，一步一步地完成研发工作。
这样的AI辅助开发的思路显然会更加靠谱，更加落地。而DDD与AI的结合，则为我们提供了全新的思路。

本项目就是一种有益的尝试，通过AI的辅助来完成DDD各个阶段的设计与开发。
通过AI的辅助，可以让设计开发人员从繁重的工作中解脱出来，包括文档的编写、程序代码的编写，以及测试用例的编写，让DDD开发更加轻松。
然而，AI不是银弹，不要奢望AI能100%地完成所有的工作。
在每个阶段中，AI通常只能完成一个大概，更多地内容需要设计开发人员一点一点地核对与更正。
与此同时，不要让AI一次性地完成大段的工作，而是让AI一个模块一个模块地做，甚至一个功能一个功能地做。
在这个过程中，不断地帮助AI修正问题、添加规则、调整思路，甚至将上一个模块的内容作为模板，来让AI去完成下一个模块的工作。
只有通过以上过程的反复调教，才能让AI最终生成我们满意的文档或代码。

基于DDD的AI辅助软件开发包括以下几个阶段：
1) AI辅助的业务需求探索阶段。在该阶段，通过提问，告知AI原始需求，让AI帮助梳理系统的业务需求，规划业务架构，划分子系统/功能模块
2) AI辅助生成用例模型与描述。在该阶段，通过前面的产出物，让AI生成各模块的用例，并按照一定格式生成每个用例的用例描述。
值得注意的是，虽然AI可以生成大量的文档，进行很多详细的描述，但并不一定都满足我们的需求。因此，需要设计人员一个一个地核对与修改，
才能得到最终满意的结果，详见`UserCaseModel.md`
3) AI辅助生成领域模型。在该阶段，将前面生成的用例模型作为输入，一个模块一个模块地让AI生成领域模型，
并定义每个领域对象的属性、方法、与其它对象的关系，详见`DomainModel.md`。如果需要，还可以对该对象添加辅助说明，说明该对象的相关业务。
领域模型与用例模型的梳理往往是业务需求的不断细化，常常也会在一些细节上进行变更。领域模型变更了，用例模型也要跟着变更。
4) AI辅助生成领域对象代码。在该阶段，将领域模型和用例模型作为输入，让AI一个模块一个模块地生成领域对象的程序代码。
5) AI辅助生成服务对象接口。在该阶段，将领域模型和用例模型作为输入，让AI生成各个模块的`Service`服务接口，然后由开发人员去实现每个接口中的方法。
当然，在这个过程中，有些方法的编码也可以使用AI生成。
6) AI辅助生成测试用例脚本。在该阶段，我不建议直接让AI生成测试脚本，而是先人工编写一个测试脚本作为模板，再结合领域模型和用例模型，
让AI去生成其它模块的测试脚本，并在这个过程中不断地更正和调整业务规则。