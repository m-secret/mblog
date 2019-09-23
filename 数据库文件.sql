-- MySQL dump 10.13  Distrib 8.0.15, for linux-glibc2.12 (x86_64)
--
-- Host: localhost    Database: myblog
-- ------------------------------------------------------
-- Server version	8.0.15

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8mb4 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `article`
--

DROP TABLE IF EXISTS `article`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `article` (
  `id` int(15) NOT NULL AUTO_INCREMENT,
  `articleId` bigint(20) NOT NULL,
  `author` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '朱新宇',
  `articleTitle` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `outline` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `articleContent` longtext NOT NULL,
  `publishTime` datetime NOT NULL,
  `lastEditTime` datetime DEFAULT NULL,
  `status` tinyint(4) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `article`
--

LOCK TABLES `article` WRITE;
/*!40000 ALTER TABLE `article` DISABLE KEYS */;
INSERT INTO `article` VALUES (5,190914220932,'朱新宇','8675','765','6875','2018-09-14 09:09:32',NULL,1),(6,190914222229,'朱新宇','测试','**Editor.md** 是一款开源的、可嵌入的 Markdown 在线编辑器（组件），基于 CodeMirror、jQuery 和 Marked 构建。','# Editor.md\r\n\r\n![](https://pandao.github.io/editor.md/images/logos/editormd-logo-180x180.png)\r\n\r\n![](https://img.shields.io/github/stars/pandao/editor.md.svg)\r\n![](https://img.shields.io/github/forks/pandao/editor.md.svg)\r\n![](https://img.shields.io/github/tag/pandao/editor.md.svg)\r\n![](https://img.shields.io/github/release/pandao/editor.md.svg)\r\n![](https://img.shields.io/github/issues/pandao/editor.md.svg)\r\n![](https://img.shields.io/bower/v/editor.md.svg)\r\n\r\n**Editor.md** : The open source embeddable online markdown editor (component), based on CodeMirror & jQuery & Marked.\r\n\r\n### Features\r\n\r\n- Support Standard Markdown / CommonMark and GFM (GitHub Flavored Markdown);\r\n- Full-featured: Real-time Preview, Image (cross-domain) upload, Preformatted text/Code blocks/Tables insert, Code fold, Search replace, Read only, Themes, Multi-languages, L18n, HTML entities, Code syntax highlighting...;\r\n- Markdown Extras : Support [ToC (Table of Contents)](https://pandao.github.io/editor.md/examples/toc.html), [Emoji](https://pandao.github.io/editor.md/examples/emoji.html), [Task lists](https://pandao.github.io/editor.md/examples/task-lists.html), [@Links](https://pandao.github.io/editor.md/examples/@links.html)...;\r\n- Compatible with all major browsers (IE8+), compatible Zepto.js and iPad;\r\n- Support [decode & fliter of the HTML tags & attributes](https://pandao.github.io/editor.md/examples/html-tags-decode.html);\r\n- Support [TeX (LaTeX expressions, Based on KaTeX)](https://pandao.github.io/editor.md/examples/katex.html), [Flowchart](https://pandao.github.io/editor.md/examples/flowchart.html) and [Sequence Diagram](https://pandao.github.io/editor.md/examples/sequence-diagram.html) of Markdown extended syntax;\r\n- Support AMD/CMD (Require.js & Sea.js) Module Loader, and Custom/define editor plugins;\r\n\r\n[README & Examples (English)](https://pandao.github.io/editor.md/en.html)\r\n  \r\n\r\n--------\r\n\r\n**Editor.md** 是一款开源的、可嵌入的 Markdown 在线编辑器（组件），基于 CodeMirror、jQuery 和 Marked 构建。\r\n\r\n![editormd-screenshot](https://pandao.github.io/editor.md/examples/images/editormd-screenshot.png \"editormd-screenshot\")\r\n\r\n#### 主要特性\r\n\r\n- 支持通用 Markdown / CommonMark 和 GFM (GitHub Flavored Markdown) 风格的语法，也可[变身为代码编辑器](https://pandao.github.io/editor.md/examples/change-mode.html)；\r\n- 支持实时预览、图片（跨域）上传、预格式文本/代码/表格插入、代码折叠、跳转到行、搜索替换、只读模式、自定义样式主题和多语言语法高亮等功能；\r\n- 支持 [ToC（Table of Contents）](https://pandao.github.io/editor.md/examples/toc.html)、[Emoji表情](https://pandao.github.io/editor.md/examples/emoji.html)、[Task lists](https://pandao.github.io/editor.md/examples/task-lists.html)、[@链接](https://pandao.github.io/editor.md/examples/@links.html)等 Markdown 扩展语法；\r\n- 支持 TeX 科学公式（基于 [KaTeX](https://pandao.github.io/editor.md/examples/katex.html)）、流程图 [Flowchart](https://pandao.github.io/editor.md/examples/flowchart.html) 和 [时序图 Sequence Diagram](https://pandao.github.io/editor.md/examples/sequence-diagram.html);\r\n- 支持[识别和解析 HTML 标签，并且支持自定义过滤标签及属性解析](https://pandao.github.io/editor.md/examples/html-tags-decode.html)，具有可靠的安全性和几乎无限的扩展性；\r\n- 支持 AMD / CMD 模块化加载（支持 [Require.js](https://pandao.github.io/editor.md/examples/use-requirejs.html) & [Sea.js](https://pandao.github.io/editor.md/examples/use-seajs.html)），并且支持[自定义扩展插件](https://pandao.github.io/editor.md/examples/define-plugin.html)；\r\n- 兼容主流的浏览器（IE8+）和 [Zepto.js](https://pandao.github.io/editor.md/examples/use-zepto.html)，且支持 iPad 等平板设备；\r\n\r\n#### Download & install\r\n\r\nDownload:\r\n\r\n[Github download](https://github.com/pandao/editor.md/archive/master.zip)\r\n\r\nNPM install :\r\n\r\n```bash\r\nnpm install editor.md\r\n```\r\n\r\nBower install :\r\n\r\n```bash\r\nbower install editor.md\r\n```\r\n\r\n#### Usages\r\n\r\n##### Create a Markdown editor\r\n\r\n```html\r\n<link rel=\"stylesheet\" href=\"editor.md/css/editormd.min.css\" />\r\n<div id=\"editor\">\r\n    <!-- Tips: Editor.md can auto append a `<textarea>` tag -->\r\n    <textarea style=\"display:none;\">### Hello Editor.md !</textarea>\r\n</div>\r\n<script src=\"jquery.min.js\"></script>\r\n<script src=\"editor.md/editormd.min.js\"></script>\r\n<script type=\"text/javascript\">\r\n    $(function() {\r\n        var editor = editormd(\"editor\", {\r\n            // width: \"100%\",\r\n            // height: \"100%\",\r\n            // markdown: \"xxxx\",     // dynamic set Markdown text\r\n            path : \"editor.md/lib/\"  // Autoload modules mode, codemirror, marked... dependents libs path\r\n        });\r\n    });\r\n</script>\r\n```\r\n\r\nIf you using modular script loader:\r\n\r\n- [Using Require.js](https://github.com/pandao/editor.md/tree/master/examples/use-requirejs.html)\r\n- [Using Sea.js](https://github.com/pandao/editor.md/tree/master/examples/use-seajs.html)\r\n\r\n##### Markdown to HTML\r\n\r\n```html\r\n<link rel=\"stylesheet\" href=\"editormd/css/editormd.preview.css\" />\r\n<div id=\"test-markdown-view\">\r\n    <!-- Server-side output Markdown text -->\r\n    <textarea style=\"display:none;\">### Hello world!</textarea>             \r\n</div>\r\n<script src=\"jquery.min.js\"></script>\r\n<script src=\"editormd/editormd.js\"></script>\r\n<script src=\"editormd/lib/marked.min.js\"></script>\r\n<script src=\"editormd/lib/prettify.min.js\"></script>\r\n<script type=\"text/javascript\">\r\n    $(function() {\r\n	    var testView = editormd.markdownToHTML(\"test-markdown-view\", {\r\n            // markdown : \"[TOC]\\n### Hello world!\\n## Heading 2\", // Also, you can dynamic set Markdown text\r\n            // htmlDecode : true,  // Enable / disable HTML tag encode.\r\n            // htmlDecode : \"style,script,iframe\",  // Note: If enabled, you should filter some dangerous HTML tags for website security.\r\n        });\r\n    });\r\n</script>    \r\n```\r\n\r\n> See the full example: [http://editor.md.ipandao.com/examples/html-preview-markdown-to-html.html](http://editor.md.ipandao.com/examples/html-preview-markdown-to-html.html)\r\n\r\n##### HTML to Markdown?\r\n\r\nSorry, Editor.md not support HTML to Markdown parsing, Maybe In the future.\r\n\r\n#### Examples\r\n\r\n[https://pandao.github.io/editor.md/examples/index.html](https://pandao.github.io/editor.md/examples/index.html)\r\n\r\n#### Options\r\n\r\nEditor.md options and default values:\r\n\r\n```javascript\r\n{\r\n    mode                 : \"gfm\",          // gfm or markdown\r\n    name                 : \"\",             // Form element name for post\r\n    value                : \"\",             // value for CodeMirror, if mode not gfm/markdown\r\n    theme                : \"\",             // Editor.md self themes, before v1.5.0 is CodeMirror theme, default empty\r\n    editorTheme          : \"default\",      // Editor area, this is CodeMirror theme at v1.5.0\r\n    previewTheme         : \"\",             // Preview area theme, default empty\r\n    markdown             : \"\",             // Markdown source code\r\n    appendMarkdown       : \"\",             // if in init textarea value not empty, append markdown to textarea\r\n    width                : \"100%\",\r\n    height               : \"100%\",\r\n    path                 : \"./lib/\",       // Dependents module file directory\r\n    pluginPath           : \"\",             // If this empty, default use settings.path + \"../plugins/\"\r\n    delay                : 300,            // Delay parse markdown to html, Uint : ms\r\n    autoLoadModules      : true,           // Automatic load dependent module files\r\n    watch                : true,\r\n    placeholder          : \"Enjoy Markdown! coding now...\",\r\n    gotoLine             : true,           // Enable / disable goto a line\r\n    codeFold             : false,\r\n    autoHeight           : false,\r\n    autoFocus            : true,           // Enable / disable auto focus editor left input area\r\n    autoCloseTags        : true,\r\n    searchReplace        : true,           // Enable / disable (CodeMirror) search and replace function\r\n    syncScrolling        : true,           // options: true | false | \"single\", default true\r\n    readOnly             : false,          // Enable / disable readonly mode\r\n    tabSize              : 4,\r\n    indentUnit           : 4,\r\n    lineNumbers          : true,           // Display editor line numbers\r\n    lineWrapping         : true,\r\n    autoCloseBrackets    : true,\r\n    showTrailingSpace    : true,\r\n    matchBrackets        : true,\r\n    indentWithTabs       : true,\r\n    styleSelectedText    : true,\r\n    matchWordHighlight   : true,           // options: true, false, \"onselected\"\r\n    styleActiveLine      : true,           // Highlight the current line\r\n    dialogLockScreen     : true,\r\n    dialogShowMask       : true,\r\n    dialogDraggable      : true,\r\n    dialogMaskBgColor    : \"#fff\",\r\n    dialogMaskOpacity    : 0.1,\r\n    fontSize             : \"13px\",\r\n    saveHTMLToTextarea   : false,          // If enable, Editor will create a <textarea name=\"{editor-id}-html-code\"> tag save HTML code for form post to server-side.\r\n    disabledKeyMaps      : [],\r\n    \r\n    onload               : function() {},\r\n    onresize             : function() {},\r\n    onchange             : function() {},\r\n    onwatch              : null,\r\n    onunwatch            : null,\r\n    onpreviewing         : function() {},\r\n    onpreviewed          : function() {},\r\n    onfullscreen         : function() {},\r\n    onfullscreenExit     : function() {},\r\n    onscroll             : function() {},\r\n    onpreviewscroll      : function() {},\r\n    \r\n    imageUpload          : false,          // Enable/disable upload\r\n    imageFormats         : [\"jpg\", \"jpeg\", \"gif\", \"png\", \"bmp\", \"webp\"],\r\n    imageUploadURL       : \"\",             // Upload url\r\n    crossDomainUpload    : false,          // Enable/disable Cross-domain upload\r\n    uploadCallbackURL    : \"\",             // Cross-domain upload callback url\r\n\r\n    toc                  : true,           // Table of contents\r\n    tocm                 : false,          // Using [TOCM], auto create ToC dropdown menu\r\n    tocTitle             : \"\",             // for ToC dropdown menu button\r\n    tocDropdown          : false,          // Enable/disable Table Of Contents dropdown menu\r\n    tocContainer         : \"\",             // Custom Table Of Contents Container Selector\r\n    tocStartLevel        : 1,              // Said from H1 to create ToC\r\n    htmlDecode           : false,          // Open the HTML tag identification \r\n    pageBreak            : true,           // Enable parse page break [========]\r\n    atLink               : true,           // for @link\r\n    emailLink            : true,           // for email address auto link\r\n    taskList             : false,          // Enable Github Flavored Markdown task lists\r\n    emoji                : false,          // :emoji: , Support Github emoji, Twitter Emoji (Twemoji);\r\n                                           // Support FontAwesome icon emoji :fa-xxx: > Using fontAwesome icon web fonts;\r\n                                           // Support Editor.md logo icon emoji :editormd-logo: :editormd-logo-1x: > 1~8x;\r\n    tex                  : false,          // TeX(LaTeX), based on KaTeX\r\n    flowChart            : false,          // flowChart.js only support IE9+\r\n    sequenceDiagram      : false,          // sequenceDiagram.js only support IE9+\r\n    previewCodeHighlight : true,           // Enable / disable code highlight of editor preview area\r\n\r\n    toolbar              : true,           // show or hide toolbar\r\n    toolbarAutoFixed     : true,           // on window scroll auto fixed position\r\n    toolbarIcons         : \"full\",         // Toolbar icons mode, options: full, simple, mini, See `editormd.toolbarModes` property.\r\n    toolbarTitles        : {},\r\n    toolbarHandlers      : {\r\n        ucwords : function() {\r\n            return editormd.toolbarHandlers.ucwords;\r\n        },\r\n        lowercase : function() {\r\n            return editormd.toolbarHandlers.lowercase;\r\n        }\r\n    },\r\n    toolbarCustomIcons   : {               // using html tag create toolbar icon, unused default <a> tag.\r\n        lowercase        : \"<a href=\\\"javascript:;\\\" title=\\\"Lowercase\\\" unselectable=\\\"on\\\"><i class=\\\"fa\\\" name=\\\"lowercase\\\" style=\\\"font-size:24px;margin-top: -10px;\\\">a</i></a>\",\r\n        \"ucwords\"        : \"<a href=\\\"javascript:;\\\" title=\\\"ucwords\\\" unselectable=\\\"on\\\"><i class=\\\"fa\\\" name=\\\"ucwords\\\" style=\\\"font-size:20px;margin-top: -3px;\\\">Aa</i></a>\"\r\n    },\r\n    toolbarIconTexts     : {},\r\n    \r\n    lang : {  // Language data, you can custom your language.\r\n        name        : \"zh-cn\",\r\n        description : \"开源在线Markdown编辑器<br/>Open source online Markdown editor.\",\r\n        tocTitle    : \"目录\",\r\n        toolbar     : {\r\n            //...\r\n        },\r\n        button: {\r\n            //...\r\n        },\r\n        dialog : {\r\n            //...\r\n        }\r\n        //...\r\n    }\r\n}\r\n```\r\n\r\n#### Dependents\r\n\r\n- [CodeMirror](http://codemirror.net/ \"CodeMirror\")\r\n- [marked](https://github.com/markedjs/marked \"marked\")\r\n- [jQuery](http://jquery.com/ \"jQuery\")\r\n- [FontAwesome](http://fontawesome.io/ \"FontAwesome\")\r\n- [github-markdown.css](https://github.com/sindresorhus/github-markdown-css \"github-markdown.css\")\r\n- [KaTeX](http://khan.github.io/KaTeX/ \"KaTeX\")\r\n- [prettify.js](http://code.google.com/p/google-code-prettify/ \"prettify.js\")\r\n- [Rephael.js](http://raphaeljs.com/ \"Rephael.js\")\r\n- [flowchart.js](http://adrai.github.io/flowchart.js/ \"flowchart.js\")\r\n- [sequence-diagram.js](http://bramp.github.io/js-sequence-diagrams/ \"sequence-diagram.js\")\r\n- [Prefixes.scss](https://github.com/pandao/prefixes.scss \"Prefixes.scss\")\r\n\r\n#### Changes\r\n\r\n[Change logs](https://github.com/pandao/editor.md/blob/master/CHANGE.md)\r\n\r\n#### License\r\n\r\nThe MIT License.\r\n\r\nCopyright (c) 2015-2019 Pandao\r\n','2019-09-14 09:22:29',NULL,1),(7,190914223837,'朱新宇','573','73553537','5533553','2019-09-14 09:38:37',NULL,1),(8,190915082748,'朱新宇','285','352','.3533.63..3','2019-09-14 19:27:48',NULL,1),(9,190915082820,'朱新宇','58835','3838','6838386386','2019-09-14 19:28:20',NULL,1),(10,190915082949,'朱新宇','75','57','5722725','2019-09-14 19:29:49',NULL,1),(11,190915084556,'朱新宇','53385','5\r\n5\r\n685','8383383','2019-09-14 19:45:56',NULL,1),(12,190915085717,'朱新宇','65132','8945','9865','2019-09-14 19:57:17',NULL,1),(13,190915085748,'朱新宇','863','35','35..3','2019-09-14 19:57:48',NULL,1),(14,190915090339,'朱新宇','257','833','833','2019-09-14 20:03:39',NULL,1),(15,190915090942,'朱新宇','8572','75','572525','2019-09-14 20:09:42',NULL,1),(16,190915092608,'朱新宇','68572','7225757','572572','2017-09-14 20:26:08',NULL,1),(17,190915092927,'朱新宇','35752725','57257','725257','2019-09-14 20:29:27',NULL,1),(18,190915093153,'朱新宇','5572','725725','752727','2019-09-14 20:31:53',NULL,1),(19,190915093354,'朱新宇','573','573','75373573','2019-09-14 20:33:54',NULL,1),(20,190915093417,'朱新宇','75\\4','5\\52','4242424','2019-09-15 09:34:17',NULL,1),(21,190915094441,'朱新宇','1','1','1','2019-09-14 20:44:41',NULL,1),(22,190915094925,'朱新宇','42','42','42','2019-09-15 09:49:25',NULL,1),(23,190915095850,'朱新宇','111','11','11','2019-09-15 10:02:45',NULL,1),(26,190915100757,'朱新宇','1111','1111','1111','2019-09-14 21:07:57',NULL,1),(28,190916175145,'朱新宇','521','521','521','2019-09-16 17:51:45',NULL,1),(29,190916212648,'朱新宇','666666','6666\r\n                ','66666','2019-09-16 21:26:48','2019-09-21 18:18:24',1),(30,190916213151,'朱新宇','777test','7777感觉怎么样\r\n                \r\n                \r\n                \r\n                ','7777感觉怎么样','2019-09-16 21:31:51','2019-09-21 18:16:10',1);
/*!40000 ALTER TABLE `article` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `category` (
  `cid` int(15) NOT NULL AUTO_INCREMENT,
  `cName` varchar(20) NOT NULL,
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'java'),(2,'面试'),(3,'Redis'),(4,'闲言'),(8,'test');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categoryOfArticle`
--

DROP TABLE IF EXISTS `categoryOfArticle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `categoryOfArticle` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cid` int(15) NOT NULL,
  `articleId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categoryOfArticle`
--

LOCK TABLES `categoryOfArticle` WRITE;
/*!40000 ALTER TABLE `categoryOfArticle` DISABLE KEYS */;
INSERT INTO `categoryOfArticle` VALUES (7,2,190914220932),(8,4,190914222229),(9,3,190914223837),(10,2,190915082748),(11,2,190915082820),(12,1,190915082949),(13,3,190915084556),(14,1,190915085717),(15,2,190915085748),(16,2,190915090339),(17,3,190915090942),(18,1,190915092608),(19,2,190915092927),(20,2,190915093153),(21,2,190915093354),(22,3,190915093417),(23,1,190915094441),(24,2,190915094925),(25,1,190915095850),(26,1,190915100757),(28,3,190916175145),(29,8,190916212648),(33,1,190916213151);
/*!40000 ALTER TABLE `categoryOfArticle` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tag`
--

DROP TABLE IF EXISTS `tag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tag` (
  `tagId` int(15) NOT NULL AUTO_INCREMENT,
  `tagName` varchar(20) NOT NULL,
  PRIMARY KEY (`tagId`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tag`
--

LOCK TABLES `tag` WRITE;
/*!40000 ALTER TABLE `tag` DISABLE KEYS */;
INSERT INTO `tag` VALUES (1,'springboot'),(2,'springcloud'),(4,'源码'),(6,'777'),(7,'test');
/*!40000 ALTER TABLE `tag` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tagsOfArticle`
--

DROP TABLE IF EXISTS `tagsOfArticle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tagsOfArticle` (
  `id` int(15) NOT NULL AUTO_INCREMENT,
  `tagId` int(15) NOT NULL,
  `articleId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tagsOfArticle`
--

LOCK TABLES `tagsOfArticle` WRITE;
/*!40000 ALTER TABLE `tagsOfArticle` DISABLE KEYS */;
INSERT INTO `tagsOfArticle` VALUES (4,1,190914220932),(5,2,190914220932),(6,4,190914220932),(7,1,190914222229),(8,6,190914222229),(9,1,190915082748),(10,2,190915082820),(11,4,190915082949),(12,2,190915084556),(13,3,190915085717),(14,2,190915085748),(15,2,190915090339),(16,2,190915090942),(17,3,190915092608),(18,2,190915092927),(19,6,190915093153),(20,2,190915093354),(21,4,190915093417),(22,2,190915094441),(23,2,190915094925),(24,2,190915095850),(25,2,190915100757),(27,2,190916175145),(41,1,190916212648),(42,6,190916212648);
/*!40000 ALTER TABLE `tagsOfArticle` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user` (
  `uid` bigint(20) NOT NULL AUTO_INCREMENT,
  `uname` varchar(20) NOT NULL,
  `tel` bigint(11) NOT NULL,
  `password` varchar(20) NOT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'msecret',123456,'123456');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'myblog'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-09-21 18:43:07
