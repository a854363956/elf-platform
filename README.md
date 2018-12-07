# elf-platform

### 关于用户操作的AIP接口 

#### 1. 登入系统 POST: /api/user/login  
HEAD:   

|字段名称          |字段值
|--------    |--------
|Content-Type|x-www-form-urlencoded

请求字段:  

|字段名称       |字段类型|备注
|-----      |-----  |-----
|loginName  |string |当前用户的登入名称
|password   |string |当前用户的密码
|equipmentId|long   |当前用户登入的设备id

返回字段:  

|字段名称      |字段类型  | 备注
|-----      |------   |----- 
|sessionCode|string   |用户登入凭证      

> 当用户调用/api/user/login 然后返回sessionCode用户登入凭证,来进行下一次的API请求   

#### 2. 获取用户拥有的机构信息 POST: /api/user/getMechanism

请求字段

|字段名称          |字段类型     |备注
|----------  |-------  |------
|sessionCode |string   |当前用户的sessionCode
|equipmentId |long     |设备类型

返回字段 

|字段名称           |字段类型    |备注
|--------     |------   |------ 
|id           |long     |机构唯一ID
|mechanismCode|long     |机构编号
|mechanismName|string   |机构名称
|invalid      |long     |是否失效
|effectiveDate|long     |有效时间

> PS: 此结构是一个数组结构,字段是数组里面的字段   

#### 3. 修改用户密码 POST: /api/user/updatePassword  

请求字段

|字段名称        |字段类型       |备注
|--------    |------      |------- 
|sessionCode |string      |用户当前登入的sessionCode
|password    |string      |用户当前登入的密码
|newPassword |string      |用户要更新的新密码   

返回字段  

|字段名称       |字段类型        |备注
|--------    |------      |------------
|affectedLine|int         |受影响的行数,如果为0表示没有更新成功,如果为1表示更新成功  

> 调用此方法用来更新用户的密码