# elf-platform

### 所有接口的统一响应包装  

|字段名称    |字段类型 |备注
|------    |----    |-----
|status    |long    |当前状态,如果状态等于200那么表示此请求服务正常处理
|data      |any     |任意类型,也就是返回给客户端包装的数据,如果是一个实体那么他将是一个JSON对象
|msg       |string  |返回的消息类型

> 注明，所有的接口都是安装此方法进行返回,如无特殊要求,默认所有的返回数据都放在data里面

### 登入系统 POST: /api/user/login  
HEAD:   

|字段名称        |字段值
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

### 获取用户拥有的机构信息 POST: /api/user/getMechanism

请求字段

|字段名称        |字段类型  | 备注
|----------  |-------  |------
|sessionCode |string   |当前用户的sessionCode
|equipmentId |long     |设备类型

返回字段 

|字段名称          |字段类型  |备注
|--------     |------   |------ 
|id           |long     |机构唯一ID
|mechanismCode|long     |机构编号
|mechanismName|string   |机构名称
|invalid      |long     |是否失效
|effectiveDate|long     |有效时间

> PS: 此结构是一个数组结构,字段是数组里面的字段