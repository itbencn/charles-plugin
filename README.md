# charles-plugin
- Charles(花瓶) HTTP抓包工具 
- 基于jar反编译+jar更新实现自定义插件开发
- 涉及源代码反编译修改 **此项目仅限学习交流**

# jar命令
```
//示例"CopyHex"
jar -uvf charles.jar com/xk72/charles/gui/transaction/actions/CopyHexToClipboardAction.class
jar -uvf charles.jar com/xk72/charles/gui/transaction/actions/CopyHexToClipboardText.class
jar -uvf charles.jar com/xk72/charles/gui/transaction/actions/CopyHexToClipboardTextComponent.class
jar -uvf charles.jar com/xk72/charles/gui/transaction/popups/TransactionViewerPopupMenu.class
```

# openjdk11.0.17 下载地址
<https://learn.microsoft.com/zh-cn/java/openjdk/download>

# 相关文档
<https://www.cnblogs.com/Baylor-Chen/p/14963207.html>
<br>
<https://www.jianshu.com/p/633c346f071b>
