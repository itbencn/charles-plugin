# charles-plugin
- Charles(花瓶) HTTP抓包工具 
- 基于jar反编译+jar更新实现自定义插件开发
- 涉及源代码反编译修改 **此项目仅限学习交流**

# 新增功能
1. UrlDecode URL解码
2. CopyRequestHex 复制十六进制文本请求数据(官方版本无法直接复制纯十六进制文本)
3. CopyResponseHex 复制十六进制文本响应数据(官方版本无法直接复制纯十六进制文本)
4. ...

# jar命令
```
//示例"CopyHex"
jar -uvf charles.jar com/xk72/charles/gui/transaction/actions/CopyHexToClipboardAction.class
jar -uvf charles.jar com/xk72/charles/gui/transaction/actions/CopyHexToClipboardText.class
jar -uvf charles.jar com/xk72/charles/gui/transaction/actions/CopyHexToClipboardTextComponent.class
jar -uvf charles.jar com/xk72/charles/gui/transaction/popups/TransactionViewerPopupMenu.class
//注意class文件路径必须和java软件包路径一致 否则替换后无法生效
//推荐使用JAR批量合并更新工具
```
# Charles汉化
使用mt管理器导入jar修改字符串常量

# openjdk11.0.17 下载地址
必须和charles的java构建版本一致
<https://learn.microsoft.com/zh-cn/java/openjdk/download>

# jadx分析工具
<https://github.com/skylot/jadx>
# jd-ui分析工具
<https://jd-gui.apponic.com/>

