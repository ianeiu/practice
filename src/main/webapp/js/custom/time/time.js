//获取当前月的第一天
function getCurrentMonthFirst() {
	var date = new Date();
	date.setDate(1);
	return date;
}

//获取当前月的最后一天
function getCurrentMonthLast() {
	var date = new Date();
	var currentMonth = date.getMonth();
	var nextMonth = ++currentMonth;
	var nextMonthFirstDay = new Date(date.getFullYear(), nextMonth, 1);
	var oneDay = 1000 * 60 * 60 * 24;
	return new Date(nextMonthFirstDay - oneDay);
}

/**
 * 获取时间字符串格式
 * @param date
 * @returns
 */
function getDateStr(date){
	var strYear = date.getFullYear();        
	var strDay = date.getDate();        
	var strMonth = date.getMonth()+1;      
	if(strMonth<10) {        
		strMonth="0"+strMonth;        
	}      
	 if(strDay<10){        
		strDay="0"+strDay;        
	}
    var datestr = strYear+"-"+strMonth+"-"+strDay;
	return datestr;
}

//获得当前日期昨天的日期      
function getYestoday(date) {
	var yesterday_milliseconds = date.getTime() - 1000 * 60 * 60 * 24;
	var yesterday = new Date();
	yesterday.setTime(yesterday_milliseconds);

	var strYear = yesterday.getFullYear();
	var strDay = yesterday.getDate();
	var strMonth = yesterday.getMonth() + 1;
	if (strMonth < 10) {
		strMonth = "0" + strMonth;
	}
	datastr = strYear + "-" + strMonth + "-" + strDay;
	return datastr;
}

// 获得上个月在昨天这一天的日期
function getLastMonthYestdy(date) {
	var daysInMonth = new Array([ 0 ], [ 31 ], [ 28 ], [ 31 ], [ 30 ], [ 31 ],
			[ 30 ], [ 31 ], [ 31 ], [ 30 ], [ 31 ], [ 30 ], [ 31 ]);
	var strYear = date.getFullYear();
	var strDay = date.getDate();
	var strMonth = date.getMonth() + 1;
	if (strYear % 4 == 0 && strYear % 100 != 0) {
		daysInMonth[2] = 29;
	}
	if (strMonth - 1 == 0) {
		strYear -= 1;
		strMonth = 12;
	} else {
		strMonth -= 1;
	}
	strDay = daysInMonth[strMonth] >= strDay ? strDay : daysInMonth[strMonth];
	if (strMonth < 10) {
		strMonth = "0" + strMonth;
	}
	if (strDay < 10) {
		strDay = "0" + strDay;
	}
	datastr = strYear + "-" + strMonth + "-" + strDay;
	return datastr;
}

// 获得上一年在昨天这一天的日期
function getLastYearYestdy(date) {
	var strYear = date.getFullYear() - 1;
	var strDay = date.getDate();
	var strMonth = date.getMonth() + 1;
	if (strMonth < 10) {
		strMonth = "0" + strMonth;
	}
	if (strDay < 10) {
		strDay = "0" + strDay;
	}
	datastr = strYear + "-" + strMonth + "-" + strDay;
	return datastr;
}

/**
 * 获取某年某月最后一天
 * @param year 年
 * @param month 月
 * @returns
 */
function getLastDay(year, month) {
	var new_year = year; // 取当前的年份
	var new_month = month++;// 取下一个月的第一天，方便计算（最后一天不固定）
	if (month > 12) // 如果当前大于12月，则年份转到下一年
	{
		new_month -= 12; // 月份减
		new_year++; // 年份增
	}
	var new_date = new Date(new_year, new_month, 1); // 取当年当月中的第一天
	/*以下选择*/
	var date_count = (new Date(new_date.getTime() - 1000 * 60 * 60 * 24))
			.getDate();// 获取当月的天数
	var last_date = new Date(new_date.getTime() - 1000 * 60 * 60 * 24);// 获得当月最后一天的日期
	return date_count;
}

var now = new Date();
var dateStr = now.getFullYear() + "-" + (now.getMonth() <9?"0"+(now.getMonth()+1):(now.getMonth()+1))+"-"+(now.getDate()<10?("0"+now.getDate()):now.getDate());
var dateStr2 = now.getFullYear() + "-" + (now.getMonth() <9?"0"+(now.getMonth()+1):(now.getMonth()+1))+"-"+(now.getDate()<10?("0"+now.getDate()):now.getDate()) 
		+" "+now.getHours()+":"+now.getMinutes()+":"+now.getSeconds();
/**
 * 获取当前年月日字符串
 * @returns {String}
 */
function getDateStr(){
	return dateStr;
}
/**
 * 获取当前年月日时分秒字符串
 * @returns {String}
 */
function getDateStr2(){
	return dateStr2;
}


