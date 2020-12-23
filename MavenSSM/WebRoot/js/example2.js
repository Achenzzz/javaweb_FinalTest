var bmapChart = echarts.init(document.getElementById('map-wrap'));



function querydata1(){
     var p=[];
	$.ajax({  
	        async : false,  
	        cache:false,  
	        type: 'post',
	     	contentType: "application/x-www-form-urlencoded; charset=utf-8",
	     	scriptCharset: 'utf-8',
	        url: "ajaxGetData1.do",
	     	success:function(data){ //请求成功后处理函数。 
	     		p=JSON.parse(data);
	     	} ,
	        error: function () {//请求失败处理函数  	
	        	        	
	        }	         
	    });
	   
return p;
}

function querygeoCoordMap(){
var p={};
	$.ajax({  
	        async : false,  
	        cache:false,  
	        type: 'post',
	     	contentType: "application/x-www-form-urlencoded; charset=utf-8",
	     	scriptCharset: 'utf-8',
	        url: "ajaxGetData.do",
	     	success:function(data){ //请求成功后处理函数。 
	     		p=JSON.parse(data); 		
	     	} ,
	        error: function () {//请求失败处理函数  	
	                	
	        }  	         
	    });
return p;
}

var data = querydata1();


var geoCoordMap = querygeoCoordMap();



var convertData = function(data) {
    var res = [];
    for(var i = 0; i < data.length; i++) {
        var geoCoord = geoCoordMap[data[i].name];
        if(geoCoord) {
            res.push({
                name: data[i].name,
                value: geoCoord.concat(data[i].value)
            });
        }
    }
    return res;
}
var option = {
    bmap: {
        center: [116.307698, 40.056975], //中心位置坐标
        zoom: 5, //地图缩放比例
        roam: true, //开启用户缩放和拖拽
        mapStyle: { // 百度地图自定义样式
            styleJson: [
                // 陆地
                {
                    "featureType": "land",
                    "elementType": "all",
                    "stylers": {
                        "color": "#073763"
                    }
                },
                // 水系
                {
                    "featureType": "water",
                    "elementType": "all",
                    "stylers": {
                        "color": "#073763",
                        "lightness": -54
                    }
                },
                // 国道与高速
                {
                    "featureType": "highway",
                    "elementType": "all",
                    "stylers": {
                        "color": "#45818e"
                    }
                },
                // 边界线
                {
                    "featureType": "boundary",
                    "elementType": "all",
                    "stylers": {
                        "color": "#ffffff",
                        "lightness": -62,
                        "visibility": "on"
                    }
                },
                // 行政标注
                {
                    "featureType": "label",
                    "elementType": "labels.text.fill",
                    "stylers": {
                        "color": "#ffffff",
                        "visibility": "on"
                    }
                },
                {
                    "featureType": "label",
                    "elementType": "labels.text.stroke",
                    "stylers": {
                        "color": "#444444",
                        "visibility": "on"
                    }
                }
            ]
        }
    },
    series: [{
        name: '销量',
        type: 'scatter',
        coordinateSystem: 'bmap', // 坐标系使用bmap
        data: convertData(data)
    }],
    visualMap: { // 视觉映射组件
        type: 'continuous',
        min: 0,
        max: 200,
        calculable: true,
        inRange: {
            color: ['#50a3ba', '#eac736', '#d94e5d']
        },
        textStyle: {
            color: '#fff'
        }
    }
}

bmapChart.setOption(option);

var bmap = bmapChart.getModel().getComponent('bmap').getBMap(); //百度地图实例

bmap.addControl(new BMap.NavigationControl());//缩放控件
bmap.addControl(new BMap.ScaleControl());//比例尺
