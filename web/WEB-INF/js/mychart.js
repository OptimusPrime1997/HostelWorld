/*package user*/

//consumeInfo.jsp
/*myConsumeLineChart->chart*/
function getMyConsumeInfoArr(orderArr,type) {
    var myConsumeArr = new Array();
    for (var i = 0, len = orderArr.length; i < len; i++) {
        myConsumeArr[i] = (orderArr[i])[type];
    }
    return myConsumeArr;
}


/* package hostel*/




/*package manager*/



