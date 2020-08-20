//BPM5841版本
var attCode = 1; //附加标识判断是否是 1 FULL_CONTROL 还是 其他
//修改附件Grid列表Attachment
function editAttachment(userName) {
    var table = document.getElementById("Attachment_shell");
    if (table != null) {
        var test = table.childNodes;
        var tr = table.getElementsByTagName("tr");
        for (var i = 0; i < tr.length; i++) {
            if (i == 0) {
                var th = document.createElement("th");
                th.innerHTML = "在线操作";
                tr[i].appendChild(th);
            } else {

                var id = tr[i].getAttribute("id");
                if (id == null) {
                    return;
                }
                //是office，禁止下载，去掉href
                if (isOffice(id)) {
                    var a = tr[i].cells[0].lastElementChild;
                    a.removeAttribute("href");
                    a.setAttribute("style", "color: #7e7a7a;text-decoration: none;font-size: 14px;font-family: auto;line-height: 21px;");
                }
                var td = document.createElement("td");
                if (isOffice(id) && isTemp(id)) {
                    if (isFullControl() == 1) {
                        td.innerHTML = " <i class='fa fa-edit' title='修改档案' onclick='javaScript:modifybtn(&apos;" + id + "&apos;,&apos;" + userName + "&apos;,&apos;" + attCode + "&apos;)' style='font-size:20px; color:#3c92dc; cursor:pointer;'></i>";
                    } else {
                        td.innerHTML = " <i class='fa fa-eye' title='查看档案' onclick='javaScript:modifybtn(&apos;" + id + "&apos;,&apos;" + userName + "&apos;,&apos;" + attCode + "&apos;)' style='font-size:20px; color:#3c92dc; cursor:pointer;'></i>";
                    }
                } else {
                    td.innerHTML = "<i class='fa fa-ban ' title='禁止操作'  style='font-size:20px; color:red; cursor:pointer;'></i> ";
                }
                tr[i].appendChild(td);
            }
        }
    }
}

// 判断此关卡附件是否有FULL_CONTROL权限。
function isFullControl() {
    //formId表单代号,系统全局变量；EFGP是SQLCommand代号
    var tDConn_EFGP = new DataSource(formId, "EFGP");
    var sql = "SELECT FormFieldAccessDefinition.formFieldAccessControl  FROM ActivityDefinition JOIN FormFieldAccessDefinition ON ActivityDefinition.formFieldAccessDefinitionOID= FormFieldAccessDefinition.OID  WHERE ActivityDefinition.OID= '" + activityOID + "'";
    var tResult = tDConn_EFGP.query(sql);
    var flag1 = tResult[0][0].indexOf("FULL_CONTROL");
    if (flag1 != -1) { //编辑
        attCode = 1;
    } else {
        attCode = 2;
    }
    return attCode;
}

//判断传入的文件是否为office文件
function isOffice(id) {
    var flag = false;
    if (id.indexOf(".doc") != -1) {
        flag = true;
    }
    if (id.indexOf(".docx") != -1) {
        flag = true;
    }
    if (id.indexOf(".ppt") != -1) {
        flag = true;
    }
    if (id.indexOf(".pptx") != -1) {
        flag = true;
    }
    if (id.indexOf(".xlsx") != -1) {
        flag = true;
    }
    if (id.indexOf(".xls") != -1) {
        flag = true;
    }
    if (id.indexOf(".pdf") != -1) {
        flag = true;
    }
    return flag;
}

// 判断附件是否是零时文件。 add by zhupeng 20191225
function isTemp(id) {
    //formId表单代号,系统全局变量；EFGP是SQLCommand代号
    var tDConn_EFGP = new DataSource(formId, "EFGP");
    var sql = "SELECT count(OID) FROM NoCmDocument WHERE id  = '" + id + "'";
    var tResult = tDConn_EFGP.query(sql);
    if (tResult[0][0] == 1) {
        return true;
    } else {
        return false;
    }
}

// 判断此视图是否在审批视图。 add by zhupeng 20191225
function isPerForm() {
    if (viewMode == "PERFORM") {
        return true;
    } else {
        return false;
    }
}

// 2019.7.2  祝朋 根据附件Id查询附件的物理名，逻辑名，附件扩展名
var databaseCfgId = "EFGP";
var editUser = "";//用户名
var attCode = ""; //编辑还是查看状态
function modifybtn(fileId, userName, attachmentCode) {
    editUser = userName;
    attCode = attachmentCode;
    var basePath = fileId + "@+" + editUser + "@+" + attCode;
    openhtml1(encodeURI(basePath));
}


// 2019.7.2  祝朋 调用软航插件接口
function openhtml1(cmd) {
    //alert(cmd);
    //判断本地是否安装插件
    var ntkoed = ntkoBrowser.ExtensionInstalled();
    //alert("ntkoed:"+ntkoed);
    if (ntkoed) {
        //打开插件
        ntkoBrowser.openWindow("/EditAttachment/editindex.html?cmd=" + cmd,false,"在线编辑","0670F32568DC510CAFC75138B6EBF9ECB2361313");
    } else {
        //没有安装插件，这跳转到下载插件页面
        window.location.href = "/EditAttachment/exeindex.html";
    }
}