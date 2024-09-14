# 电子商务系统领域模型

## 用户授权

### 领域对象：

1.**用户（User）-- 实体**
- **属性**：
  - 用户ID（Id）：唯一标识。
  - 用户名（Username）：用户注册的名称。
  - 密码（Password）：密码。
  - 账户过期（AccountExpired）：账户已经超过有效期。
  - 账户被锁（AccountLocked）：账户被上锁。
  - 证书过期（CredentialsExpired）：证书已经超过有效期。
  - 不可用（disabled）：账户不可用。
  - 用户类型（UserType）：用户类型，如管理员、供应商、客户
- **方法**：
  - register(User): 注册新用户
  - modify(User): 用户更新信息
  - remove(userId)：管理员删除用户
  - load(userId)：查找用户
  - removeByName(name)：管理员根据用户名删除用户
  - loadByName(name)：根据用户名查找用户
  - changePassword(OldPassword, NewPassword): 用户自己修改密码
  - existsUser(name)：根据用户名查找用户是否存在
- **关系**：
  - 多对多：User 与 Role（一个用户可以有多个角色，一个角色可以分配给多个用户）
  - 多对多：User 与 Authority（一个用户可以有多个权限，一个权限可以分配给多个用户）
- **说明**：
  - 用户在注册时分为三种类型：
    - 管理员：管理整个系统，包括所有人员的认证、授权，供应商的管理，客户的管理，等等
    - 供应商：通过它的员工管理该供应商的产品，及其销售、库存等情况
    - 客户：本系统真正服务的对象，在这里购物、交易，参与各种促销活动
  - 不同类型的用户，在登录以后，进入到不同的前端子系统。
  - 对用户的授权被封装在了用户注册与更新的过程中
  - 用户可以通过角色获得授权，也可以直接申请某些权限

2.**角色（Role）-- 实体**
- **属性**：
  - ID: 角色唯一标识
  - Name: 角色名称
  - Description: 角色描述
- **方法**：
  - create(Role)：管理员创建角色，给角色授权
  - modify(Role)：管理员修改角色，修改角色权限
  - remove(roleId)：管理员删除角色
  - load(roleId)：查找角色，并查看角色的授权
- **关系**：
  - 多对多：Role 与 User（一个角色可以分配给多个用户，一个用户可以有多个角色）
  - 多对多：Role 与 Authority（一个角色可以有多个权限，一个权限可以分配给多个角色）

3.**权限（Authority）-- 实体**
- **属性**：
  - ID: 权限唯一标识
  - Name: 权限名称
  - Description: 权限描述
- **方法**：
  - create(Authority): 管理员创建权限
  - modify(Authority): 管理员修改权限
  - remove(authorityId): 管理员删除权限
  - load(authorityId): 查找权限信息
- **关系**：
  - 多对多：Authority 与 User（一个权限可以分配给多个用户，一个用户可以有多个权限）
  - 多对多：Authority 与 Role（一个权限可以分配给多个角色，一个角色可以有多个权限）

4.**管理员（Administrator） -- 实体**
- **属性**：
  - 继承自 User 的所有属性

5.**供应商员工（Staff） -- 实体**
- **属性**：
  - 继承自 User 的所有属性

6.**客户（Customer） -- 实体**
- **属性**：
  - 继承自 User 的所有属性

## 客户管理

### 领域对象：

1.**客户（Customer） - 实体**
- **属性**：
  - 客户ID（Id）：唯一标识。
  - 姓名（Name）：用户的真实姓名。
  - 性别（Gender）：客户性别。
  - 身份证（identification）：客户身份证号。
  - 出生日期（birthdate）：客户的出生日期。
  - 邮箱（Email）：客户的联系邮箱。
  - 手机号（PhoneNumber）：客户的联系电话。
  - 注册时间（CreateTime）：客户注册的时间。
  - 更新时间（ModifyTime）：客户最后更新的时间。
- **方法**：
  - register(Customer)：注册新用户。
  - modify(Customer)：更新客户资料。
  - remove(customerId)：删除客户资料。
  - load(customerId)：根据ID查找客户及其资料。
  - exists(customerId)：检查该客户是否存在。
  - removeByName(name)：通过姓名删除客户资料。
  - loadByName(name)：根据姓名查找客户及其资料。
  - loadForList(customerIds)：根据多个ID查找客户及其资料。
  - loadAddress(Long addressId)：根据地址ID查找客户的地址信息。
  - existsAddress(Long addressId)：根据地址ID查找客户的地址是否存在。
  - loadAddressForList(Collection<Long> addressIds)：根据多个地址ID查找客户地址。
- **关系**：
  - 一对多：关联多个**地址**（Address），并且是聚合关系。
  - 一对一：有且只有关联一个**用户**（User）。
- **说明**：
  - 客户是在本系统中购买商品、进行消费的人。
  - 客户是在第一次登录系统时，自助填写并创建客户档案
  - 客户在创建时会自动创建一个用户，日后通过该用户登录系统
  - 客户档案只能由客户自己或系统管理员可以修改
  - 客户档案只能由系统管理员可以删除
  - 可以添加多个地址，用于日后订单的配送，地址由客户自己添加
  - 地址的添加被封装在了客户注册与更新的过程中

2.**地址（Address） - 实体**
- **属性**：
  - 地址ID（Id）：唯一标识。
  - 客户ID（CustomerId）：地址所属客户的ID。
  - 国家ID（CountryId）：地址所属国家的ID。
  - 省份ID（ProvinceId）：地址所属国家的ID。
  - 地市ID（CityId）：地址所属国家的ID。
  - 区县ID（DistrictId）：地址所属国家的ID。
  - 详细地址（Address）：地址的详细内容，如街道、楼层、门牌号等。
  - 联系电话（PhoneNumber）：地址的联系电话
- **方法**：
  - 无
- **关系**：
  - 多对一：关联一个**国家**（Country）
  - 多对一：关联一个**省份**（Province）
  - 多对一：关联一个**地市**（City）
  - 多对一：关联一个**区县**（District）

3.**国家（Country）- 值对象**
- **属性**：
  - 国家ID（Id）：唯一标识。
  - 国家名称（Name）：国家的名称。
  - 国家代码（CountryCode）：国际标准化的国家代码，如ISO 3166-1 alpha-2。
  - 货币类型（CurrencyType）：国家使用的货币类型。
- **方法**：
  - load(id)：根据ID查找国家信息
  - exists(id)：根据ID检查该国家是否存在
  - loadAll()：查找所有的国家
- **关系**：
  - 无

4.**省份（Province）- 值对象**
- **属性**：
  - 省份ID（Id）：唯一标识。
  - 省份名称（Name）：省份的名称。
  - 国家ID（CountryId）：所属国家的ID。
  - 省份代码（ProvinceCode）：省份的代码。
- **方法**：
  - load(id)：根据ID查找省份信息
  - exists(id)：根据ID检查该省份是否存在
  - loadAll()：查找所有的省份
- **关系**：
  - 无

5.**地市（City）- 值对象**
- **属性**：
  - 地市ID（Id）：唯一标识。
  - 地市名称（Name）：地市的名称。
  - 省份ID（ProvinceId）：所属省份的ID。
  - 地市代码（CityCode）：地市的代码。
- **方法**：
  - load(id)：根据ID查找地区信息
  - exists(id)：根据ID检查该地区是否存在
  - loadAll()：查找所有的地区
- **关系**：
  - 无

6.**区县（District）- 值对象**
- **属性**：
  - 区县ID（Id）：唯一标识。
  - 区县名称（Name）：区县的名称。
  - 地市ID（CityId）：所属地市的ID。
  - 区县代码（DistrictCode）：区县的代码。
- **方法**：
  - load(id)：根据ID查找区县信息
  - exists(id)：根据ID检查该区县是否存在
  - loadAll()：查找所有的区县
- **关系**：
  - 无

## 会员管理

### 领域对象：

1.**会员（Vip） - 实体**
- **属性**：
  - 会员ID（Id）：唯一标识。
  - 加入时间（CreateTime）：成为会员的时间。
  - 更新时间（ModifyTime）：最后一次更新的时间。
  - 会员等级（VipLevel）：会员的等级，如银卡、金卡、白金卡。
  - 积分（Points）：会员当前的积分总数。
  - 累积积分（AccumulatedPoints）：购买商品后累积的积分总数。
- **方法**：
  - register(Vip)：客户注册成为会员。
  - modify(Vip)：会员对自己的信息进行更新。
  - remove(Vip)：系统管理员删除会员信息。
  - load(vipId)：根据ID查找会员信息。
  - exists(vipId)：根据ID检查会员是否存在。
  - loadByCustomer(customer)：根据客户查找对应的会员信息。
  - accumulatePoints(vipId,points)：购买商品后累积积分。
  - redeemPoints(vipId,points)：使用积分进行兑换。
- **关系**：
  - 一对一：一个会员属于一个**客户**（Customer），一个客户最多只能有一个会员。
- **说明**：
  - 已经在本系统中注册的用户才可以注册会员，一个客户只能申请一个会员
  - 通过购买商品，会员可以根据积分规则获得积分
  - 积分可以兑换商品，兑换商品是会扣除相应的积分，但累计积分不变
  - 当累计积分达到某个阈值时，会员等级会自动升级，从而获得更多优惠与特权

2.**积分规则（PointsRule） - 值对象**
- **属性**：
  - 规则ID（Id）：唯一标识。
  - 购买金额对应积分（PointsPerDollar）：每消费一定金额获得的积分数。
  - 积分上限（PointsCap）：单次购买可获得的积分上限。
- **方法**：
  - calculatePoints(vipId,amount)：根据消费金额计算积分。
  - load(id)：根据ID查找积分规则
  - exists(id)：根据ID检查某个积分规则是否存在
  - loadAll()：查找所有的积分规则

3.**升级规则（UpgroundRule） - 值对象**
- **属性**：
  - 规则ID（Id）：唯一标识。
  - 会员类型（VipLevel）：会员的等级
  - 积分要求（PointsNeed）：达到该等级所需的积分
- **方法**：
  - calculateLevel(vipId)：根据会员累计积分计算会员等级
  - load(id)：根据ID查找升级规则
  - exists(id)：根据ID检查某个升级规则是否存在
  - loadAll()：查找所有的升级规则

## 供应商管理

### 领域对象：

1.**供应商（Supplier） - 实体**
- **属性**：
  - 供应商ID（Id）：唯一标识。
  - 名称（Name）：供应商的名称。
  - 联系电话（PhoneNumber）：供应商的联系电话。
  - 电子邮箱（Email）：供应商的联系邮箱。
  - 地址（Address）：供应商的办公地址。
  - 创建时间（CreateTime）：创建新供应商的时间。
  - 更新时间（ModifyTime）：供应商信息最后更新的时间。
- **方法**：
  - create(Supplier)：系统管理员添加新的供应商。
  - modify(Supplier)：系统管理员更新供应商信息。
  - remove(supplierId)：系统管理员删除供应商。
  - load(supplierId)：查找供应商信息。
  - exists(supplierId)：检查供应商是否存在。
- **关系**：
  - 无
- **说明**：
  - 每个供应商可以各自管理各自的员工、产品、库存及销售信息
  - 供应商由系统管理员创建，并创建第一个员工
  - 供应商信息，及其员工、产品、库存及销售信息，都是由自己的员工进行管理

2.**员工（Staff） - 实体**
- **属性**：
  - 员工ID（Id）：唯一标识。
  - 姓名（Name）：用户的真实姓名。
  - 性别（Gender）：员工性别。
  - 身份证（identification）：员工身份证号。
  - 出生日期（birthdate）：员工的出生日期。
  - 邮箱（Email）：员工的联系邮箱。
  - 手机号（PhoneNumber）：员工的联系电话。
  - 供应商ID（SupplierId）：员工所属的供应商ID。
  - 注册时间（CreateTime）：员工登记的时间。
  - 更新时间（ModifyTime）：员工信息最后更新的时间。
- **方法**：
  - create(Staff)：登记新员工。
  - modify(Staff)：更新员工资料。
  - remove(staffId)：删除员工资料。
  - load(staffId)：根据ID查找员工及其资料。
  - loadBySupplier(supplierId)：根据供应商ID查找相应的员工及其资料。
  - existsOfTheSupplier(supplierId)：根据供应商ID查找其是否还有相应的员工。
- **关系**：
  - 多对一：一个员工隶属于一个**供应商**（Spplier）,一个供应商可以拥有多个员工。
- **说明**：
  - 员工是隶属于某个供应商的员工，代表该供应商管理其名下的商品、库存、销售等信息
  - 员工是由系统管理员或该供应商名下的其它员工创建的
  - 员工在创建时会自动创建一个用户，日后通过该用户登录系统
  - 员工档案只能由自己、该供应商的员工或系统管理员可以修改
  - 员工档案只能由该供应商的员工或系统管理员可以删除

## 商品管理

### 领域对象：

1.**商品（Product） - 实体**
- **属性**：
  - 商品ID（Id）：唯一标识。
  - 名称（Name）：商品名称。
  - 描述（Description）：商品详细描述。
  - 价格（Price）：商品售价。
  - 供应商ID（SupplierId）：所属供应商的ID。
  - 商品分类ID（CategoryId）：商品的分类ID。
  - 品牌ID（BrandId）：商品的品牌ID。
  - 展示图片（Image）：商品的展示图片。
  - 提示标签（Tip）：商品的提示标签，如热卖、自营、打折等
  - 状态（Status）：如上架、下架、缺货等。
  - 创建时间（CreateTime）：创建新商品的时间。
  - 更新时间（ModifyTime）：商品信息最后更新的时间。
- **方法**：
  - create(Product)：由供应商的员工创建新的产品。
  - modify(Product)：由该供应商的员工维护该产品信息。
  - remove(productId)：由该供应商的员工删除产品。
  - load(productId)：查找产品信息。
  - exists(productId)：检查相应产品是否存在。
- **关系**：
  - 多对一：一个产品属于一个**供应商**（Supplier），但一个供应商可以有多个产品
  - 多对一：一个产品属于一个**商品分类**（ProductCategory），但一个产品分类中有多个产品
  - 多对一：一个产品属于一个**品牌**（Brand），但一个品牌中有多个产品

2.**商品分类（ProductCategory） - 值对象**
- **属性**：
  - 分类ID（Id）：唯一标识。
  - 名称（Name）：分类名称。
  - 描述（Description）：分类描述。
  - 上级分类ID（ParentId）：该分类的上级分类ID
- **方法**：
  - load(categoryId)：根据ID查找商品分类
  - exists(categoryId)：根据ID检查商品分类是否存在
  - loadAll()：查找所有商品分类
- **关系**：
  - 无

3.**品牌（Brand） - 值对象**
- **属性**：
  - 品牌ID（Id）：唯一标识。
  - 名称（Name）：品牌名称。
  - 描述（Description）：品牌描述。
- **方法**：
  - load(brandId)：根据ID查找品牌
  - exists(brandId)：根据ID检查品牌是否存在
  - loadAll()：查找所有商品分类
- **关系**：
  - 无

## 库存管理

### 领域对象：

1.**库存（Inventory） - 实体**
- **属性**：
  - 库存ID（Id）：唯一标识。
  - 当前数量（Quantity）：当前库存数量。
  - 更新时间（UpdateTime）：库存最后更新的时间。
- **方法**：
  - stockIn(id,quantity)：入库，如果还没有库存就建立库存。
  - stockOut(id,quantity)：出库，包括库存扣减、库存调拨等
  - remove(id)：删除库存
  - check(id)：检查库存
- **关系**：
  - 一对一：一个库存关联一个**商品**（Product）。

2.**商品库存记录（InventoryRecord） - 实体**
- **属性**：
  - 记录ID（Id）：唯一标识。
  - 商品ID（ProductID）：关联的商品标识。
  - 变化数量（Quantity）：库存变化的数量。
  - 变化时间（UpdateTime）：库存变化的时间。
  - 进行的操作（Operation）：库存变化的操作，如入库、库存扣减、库存调拨等
- **方法**：
  - insert(InventoryRecord)：记录每次库存的变动。
  - remove(id)：删除某条库存变动记录
- **关系**：
  - 多对一：多个库存记录属于一个**商品**（Product）。

## 订单管理

### 领域对象：

1.**订单（Order） - 实体**
- **属性**：
  - 订单ID（Id）：唯一标识。
  - 客户ID（CustomerID）：下订单的客户标识。
  - 地址ID（AddressId）：订单配送的地址ID。
  - 订单状态（Status）：如待支付、进行中、已完成、已取消。
  - 订单金额（Amount）：订单的总金额。
  - 下单时间（OrderTime）：订单创建的时间。
  - 更新时间（ModifyTime）：订单最后更新的时间。
- **方法**：
  - create(Order)：创建新的订单。
  - modify(Order)：客户修改自己的订单。
  - remove(orderId)：客户删除自己的订单。
  - load(orderId)：查找订单。
  - placeOrder(Order)：提交订单，提交以后就开始进入支付流程。
  - cancelOrder(orderId)：在没有支付订单前取消订单。
  - payoff(orderId)：支付订单金额，完成支付以后将库存扣减，并进入物流流程。
  - returnGoods(orderId)：在支付订单以后退货。
- **关系**：
  - 多对一：一个订单只能有一个**客户**（Customer），一个客户可以有多个订单
  - 多对一：一个订单只能有一个**地址**（Address），一个地址可以有多个订单
  - 一对多：一个订单包含多个**订单明细**（OrderItem），它们是聚合关系

2.**订单明细（OrderItem） - 实体**
- **属性**：
  - 订单明细ID（Id）：唯一标识。
  - 订单ID（OrderId）：所属订单的ID。
  - 商品ID（ProductID）：关联的商品标识。
  - 数量（Quantity）：商品的数量。
  - 单价（UnitPrice）：商品的单价。
  - 金额（Amount）：该商品项的金额。
- **方法**：
  - 无
- **关系**：
  - 无

3.**支付（Payment） - 实体**
- **属性**：
  - 支付ID（Id）：唯一标识。
  - 金额（Amount）：应付金额。
  - 支付方式（Method）：支付方式，如信用卡、PayPal、银行转账。
  - 支付状态（Status）：如待支付、支付成功、支付失败。
  - 支付时间（PaymentTime）：支付完成的时间。
- **方法**：
  - payoff(orderId)：支付订单的金额。
  - refund(orderId)：退货时进行退款。
  - check(orderId)：检查订单的支付情况。
- **关系**：
  - 一对一：一个**订单**（Order）只能有一个支付。
