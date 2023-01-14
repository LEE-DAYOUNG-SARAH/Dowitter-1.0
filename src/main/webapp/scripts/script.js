/**
 * 	arguments[0] : formObj
	arguments[1] : to do what
	arguments[2] : check blank(boolean)
	arguments[3] : check password equals
 */

function doWhat(){
	var formObj = arguments[0];
	var flag=true;
	if(arguments[2]){
		formObj.method="post";
		flag=hasBlank(formObj);
	} 
	if(arguments[3]){
		formObj.method="post";
		flag = comparePw(formObj);
	}
	
	if(flag){
		formObj.action = arguments[1];
		formObj.submit();
	}
}
function hasBlank(formObj){
	var notChk = ["BUTTON", "HIDDEN"];
	for (var i = 0; i < formObj.length; i++) {
		if (notChk.indexOf(formObj[i].type.toUpperCase()) == -1) {
			var inputVal = formObj[i].value.trim();
			if (!inputVal.length) {
				alert("입력누락:" + formObj[i].title)
				formObj[i].focus();
				return false
			}
		}
	}
	return true;
}
function comparePw(formObj){
	var pass = [];
	var pIdx = 0;
	
	for(var i=0;i<formObj.length;i++){
		if(formObj[i].type.toUpperCase() == "PASSWORD"){
			pass[pIdx] = formObj[i];
			pIdx++;
		}
	}
	if(pass[0].value != pass[1].value){
		alert("비밀번호가 일치하지 않습니다.");
		pass[0].focus();
		return false;
	}
	return true;
}

function hideModifier(){
	document.getElementById("modifierWrap").classList.remove('show');
}

//jquery
$(document).ready(function(){
	$('.feedModify').on("click", function(){
		var deptForm = $(this).closest("form")
		var deptDnum = deptForm.attr('name');
		var deptDcon = deptForm.children('.feedContent').text();
		$(".modifier input[name='d_num']").val(deptDnum);
		$(".modifier textarea").val(deptDcon);
		$("#modifierWrap").addClass('show');
		$(".modifier textarea").focus();
	})
});