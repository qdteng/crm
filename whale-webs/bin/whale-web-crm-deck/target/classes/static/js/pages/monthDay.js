/*monthDay添加俩个月份和日期的id名字*/
monthDay(birth_month_one,birth_day_one) 
monthDay(birth_month_two,birth_day_two)
 
function monthDay(birth_month,birth_day){
	var i = -1;
	// 添加月份
	for (i = 1; i <= 12; i++) {
		     addOption(birth_month, i, i);
		}
		// 添加天份，先默认31天
		for (i = 1; i <= 31; i++) {
		    addOption(birth_day, i, i);
		}

}
	
// 设置每个月份的天数
function setDays( month,day) {
	var monthDays = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];
	var myDate=new Date();
	var yea = myDate.getFullYear();
	var mon = month.options[month.selectedIndex].text;
	var num = monthDays[mon - 1];
	if (mon == 2 && isLeapYear(yea)) {
		num++;
	}
	for (var j = day.options.length - 1; j >=num; j--) {
           day.remove(j);
       }
       for (var i = day.options.length; i <= num; i++) {
           addOption(day,i,i);
       }
}
	 
// 判断是否闰年
function isLeapYear(year)
{
	return (year % 4 == 0 || (year % 100 == 0 && year % 400 == 0));
}
	 
// 向select尾部添加option
function addOption(selectbox, text, value) {
	var option = document.createElement("option");
	option.text = text;
    option.value = value;
    selectbox.options.add(option);
}

//点击空白地方关闭弹窗

$(document).mouseup(function(e){
  var _con = $('.jiezhi,.meinian,.monthDay ');   // 设置目标区域
  if(!_con.is(e.target) && _con.has(e.target).length === 0){ 
	  $('.monthDay').hide();
  }
});
