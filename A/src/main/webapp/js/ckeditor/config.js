﻿/*
Copyright (c) 2003-2012, CKSource - Frederico Knabben. All rights reserved.
For licensing, see LICENSE.html or http://ckeditor.com/license
*/

CKEDITOR.editorConfig = function( config )
{
	// Define changes to default configuration here. For example:
	config.language = 'zh-cn';
	 config.toolbar = "Full"; 
	// config.uiColor = '#AADC6E';
	// 在 CKEditor 中集成 CKFinder，注意 ckfinder 的路径选择要正确。 
	/*
	 config.filebrowserBrowseUrl = 'ckfinder/ckfinder.html',

     config.filebrowserUploadUrl="actions/ckeditorUploadAction";
     var pathName = window.document.location.pathname;
     //获取带"/"的项目名，如：/uimcardprj
     var projectName = pathName.substring(0, pathName.substr(1).indexOf('/') + 1);
     config.filebrowserImageUploadUrl = projectName+'/system/upload.do'; //固定路径

	 config.filebrowserImageBrowseUrl = 'ckfinder/ckfinder.html?type=Images',
	 config.filebrowserFlashBrowseUrl = 'ckfinder/ckfinder.html?type=Flash',
	 config.filebrowserUploadUrl = 'ckfinder/core/connector/java/connector.java?command=QuickUpload&type=Files',
	 config.filebrowserImageUploadUrl = 'ckfinder/core/connector/java/connector.java?command=QuickUpload&type=Images',
	 config.filebrowserFlashUploadUrl = 'ckfinder/core/connector/java/connector.java?command=QuickUpload&type=Flash',
	 config.filebrowserWindowWidth = '1000',
	 config.filebrowserWindowHeight = '700'*/

	 config.filebrowserUploadUrl="/ckeditorUpload";
	var pathName = window.document.location.pathname;
    //获取带"/"的项目名，如：/uimcardprj
    var projectName = pathName.substring(0, pathName.substr(1).indexOf('/') + 1);
    config.filebrowserImageUploadUrl = projectName+'/system/upload.do'; //固定路径



};
