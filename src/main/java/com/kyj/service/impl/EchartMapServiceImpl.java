package com.kyj.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.abel533.echarts.Label;
import com.github.abel533.echarts.Option;
import com.github.abel533.echarts.axis.AxisLine;
import com.github.abel533.echarts.axis.CategoryAxis;
import com.github.abel533.echarts.axis.SplitLine;
import com.github.abel533.echarts.axis.ValueAxis;
import com.github.abel533.echarts.code.LineType;
import com.github.abel533.echarts.code.Magic;
import com.github.abel533.echarts.code.Orient;
import com.github.abel533.echarts.code.Symbol;
import com.github.abel533.echarts.code.Tool;
import com.github.abel533.echarts.code.Trigger;
import com.github.abel533.echarts.code.X;
import com.github.abel533.echarts.code.Y;
import com.github.abel533.echarts.data.Data;
import com.github.abel533.echarts.data.PieData;
import com.github.abel533.echarts.feature.MagicType;
import com.github.abel533.echarts.series.Bar;
import com.github.abel533.echarts.series.Effect;
import com.github.abel533.echarts.series.GeoCoord;
import com.github.abel533.echarts.series.Line;
import com.github.abel533.echarts.series.MarkLine;
import com.github.abel533.echarts.series.MarkPoint;
import com.github.abel533.echarts.series.Pie;
import com.github.abel533.echarts.style.ItemStyle;
import com.github.abel533.echarts.style.LineStyle;
import com.kyj.common.utils.StringUtils;
import com.kyj.mapper.EchartMap1Mapper;
import com.kyj.mapper.EchartMap2Mapper;
import com.kyj.mapper.EchartMap3CustomMapper;
import com.kyj.mapper.EchartMap3Mapper;
import com.kyj.mapper.EchartMap4Mapper;
import com.kyj.mapper.EchartTest1Mapper;
import com.kyj.mapper.EchartTest2Mapper;
import com.kyj.po.EchartMap1;
import com.kyj.po.EchartMap1Example;
import com.kyj.po.EchartMap2;
import com.kyj.po.EchartMap2Example;
import com.kyj.po.EchartMap3;
import com.kyj.po.EchartMap3Example;
import com.kyj.po.EchartMap4;
import com.kyj.po.EchartMap4Example;
import com.kyj.po.EchartTest1;
import com.kyj.po.EchartTest1Example;
import com.kyj.po.EchartTest2;
import com.kyj.po.EchartTest2Example;
import com.kyj.service.EchartMapService;
import com.kyj.service.EchartService;

@Service
public class EchartMapServiceImpl implements EchartMapService {

	@Autowired
	private EchartMap1Mapper echartMap1Mapper;
	@Autowired
	private EchartMap2Mapper echartMap2Mapper;
	@Autowired
	private EchartMap3Mapper echartMap3Mapper;
	@Autowired
	private EchartMap3CustomMapper echartMap3CustomMapper;
	@Autowired
	private EchartMap4Mapper echartMap4Mapper;

	@Override
	public Option selectMap1() throws Exception {
		EchartMap1Example echartMap1Example = new EchartMap1Example();
		EchartMap1Example.Criteria criteria = echartMap1Example.createCriteria();
		criteria.andIphoneTypeIsNotNull();
		Option option = new Option();
		List<EchartMap1> list = echartMap1Mapper.selectByExample(echartMap1Example);
		
		option.title().text("iPhone在中国销量").subtext("数据库测试数据").x(X.center);
		option.tooltip(Trigger.item);
		// 设置图例,居中底部显示，显示边框
		option.legend().data("iphone3", "iphone4", "iphone5").orient(Orient.vertical).x(X.left).y(Y.top);
		option.dataRange().calculable(true).text("高", "低").max(2500).min(0).x(X.left).y(Y.bottom);

		option.toolbox().show(true).orient(Orient.vertical)
				.feature(Tool.mark, Tool.dataView, Tool.restore, Tool.saveAsImage).x(X.right).y(Y.center);
		option.roamController().show(true).mapTypeControl("china", true).x(X.right);

		ItemStyle dataStyle = new ItemStyle();
		dataStyle.normal().label().show(true);
		dataStyle.emphasis().label().show(true);
		com.github.abel533.echarts.series.Map map = new com.github.abel533.echarts.series.Map("iphone3");

		ItemStyle dataStyle1 = new ItemStyle();
		dataStyle.normal().label().show(true);
		dataStyle.emphasis().label().show(true);
		com.github.abel533.echarts.series.Map map1 = new com.github.abel533.echarts.series.Map("iphone4");

		ItemStyle dataStyle2 = new ItemStyle();
		dataStyle.normal().label().show(true);
		dataStyle.emphasis().label().show(true);
		com.github.abel533.echarts.series.Map map2 = new com.github.abel533.echarts.series.Map("iphone5");
		// 根据获取的数据赋值
		for (EchartMap1 echartMap1 : list) {
			// 增加类目，值为日期
			if ("iphone3".equals(echartMap1.getIphoneType())) {
				map.mapType("china").roam(false).itemStyle(dataStyle).data(new Data(echartMap1.getProvName(), echartMap1.getSaleTotal()));
			} else if ("iphone4".equals(echartMap1.getIphoneType())) {
				map1.mapType("china").roam(false).itemStyle(dataStyle1).data(new Data(echartMap1.getProvName(), echartMap1.getSaleTotal()));
			} else if ("iphone5".equals(echartMap1.getIphoneType())) {
				map2.mapType("china").roam(false).itemStyle(dataStyle2).data(new Data(echartMap1.getProvName(), echartMap1.getSaleTotal()));
			}
		}
		// 设置数据
		option.series(map, map1, map2);
		return option;
	}
	
	@Override
	public Option selectMap2() throws Exception {
		EchartMap2Example echartMap2Example = new EchartMap2Example();
		EchartMap2Example.Criteria criteria = echartMap2Example.createCriteria();
		criteria.andCityNameIsNotNull();
		Option option = new Option();
		List<EchartMap2> list = echartMap2Mapper.selectByExample(echartMap2Example);
		
		option.title().text("全国34个省市自治区票件量情况").subtext("全国和省份之间点击切换").x(X.center);
		option.tooltip(Trigger.item);
		option.tooltip().formatter("滚轮切换或点击进入该省<br/>{b}");
		// 设置图例,居中底部显示，显示边框
		option.legend().data("随机数据").orient(Orient.vertical).x(X.left).y(Y.top);
		option.dataRange().calculable(true).text("高", "低").color("orange","yellow").max(10000).min(0).x(X.left).y(Y.bottom);
		
		option.toolbox().show(true).orient(Orient.vertical)
		.feature(Tool.mark, Tool.dataView, Tool.restore, Tool.saveAsImage).x(X.right).y(Y.center);
		/*option.roamController().show(true).mapTypeControl("china", true).x(X.right);*/
		
		ItemStyle dataStyle = new ItemStyle();
		dataStyle.normal().label().show(true);
		dataStyle.emphasis().label().show(true);
		com.github.abel533.echarts.series.Map map = new com.github.abel533.echarts.series.Map("随机数据");
		map.mapType("china").selectedMode("single").itemStyle(dataStyle);;
		// 根据获取的数据赋值
		for (EchartMap2 echartMap2 : list) {
			// 增加类目，值为日期
			map.data(new Data(echartMap2.getCityName(), echartMap2.getShipmentTotal()));
		}
		// 设置数据
		option.series(map);
		return option;
	}
	
	@Override
	public Option selectMap3() throws Exception {
		/*EchartMap1Example echartMap1Example = new EchartMap1Example();
		EchartMap1Example.Criteria criteriaProv = echartMap1Example.createCriteria();
		criteriaProv.andIphoneTypeEqualTo("iphone5");
		echartMap1Example.setDistinct(true);
		List<EchartMap1> listProv = echartMap1Mapper.selectByExample(echartMap1Example);*/
		
		EchartMap2Example echartMap2Example = new EchartMap2Example();
		EchartMap2Example.Criteria criteria = echartMap2Example.createCriteria();
		criteria.andCityNameIsNotNull();
		Option option = new Option();
		List<EchartMap2> list = echartMap2Mapper.selectByExample(echartMap2Example);
		//option.title().text("全国34个省市自治区票件量情况").subtext("全国和省份之间点击切换").x(X.center);
		/*option.tooltip(Trigger.item);
		// 设置图例,居中底部显示，显示边框
		//option.legend().data("随机数据").orient(Orient.vertical).x(X.right);
		option.animation(false);
		//option.dataRange().orient(Orient.horizontal).text("高", "低").color("orange","yellow").splitNumber(0).max(10000).min(0).x(X.right);
		
		option.toolbox().show(true).orient(Orient.vertical)
		.feature(Tool.mark, Tool.dataView, Tool.restore, Tool.saveAsImage).x(X.right).y(Y.center);
		option.roamController().show(true).mapTypeControl("china", true).x(X.right);
		
		ItemStyle dataStyleProv = new ItemStyle();
		//dataStyleProv.normal().label().show(true);
		dataStyleProv.emphasis().label().show(true);
		com.github.abel533.echarts.series.Map mapProv = new com.github.abel533.echarts.series.Map("选择器");
		mapProv.mapType("china").roam(true).mapLocation().x(X.left).y(Y.top).width("30%");
		mapProv.tooltip().setTrigger(Trigger.item);
		mapProv.tooltip().formatter("{b}");
		mapProv.selectedMode("single").itemStyle(dataStyleProv);
		// 根据获取的数据赋值
		for (EchartMap1 echartMap1 : listProv) {
			// 增加类目，值为日期
			mapProv.data(new Data(echartMap1.getProvName()).selected(false));
		}*/
		
		ItemStyle dataStyle = new ItemStyle();
		dataStyle.normal().label().show(true);
		dataStyle.emphasis().label().show(true);
		com.github.abel533.echarts.series.Map map = new com.github.abel533.echarts.series.Map("随机数据");
		map.mapType("selectedProvince").roam(true).mapLocation().x("35%");
		map.itemStyle(dataStyle);
		// 根据获取的数据赋值
		for (EchartMap2 echartMap2 : list) {
			// 增加类目，值为日期
			map.data(new Data(echartMap2.getCityName(), echartMap2.getShipmentTotal()));
		}
		// 设置数据
		option.series(map);
		return option;
	}
	
	/* (non-Javadoc)
	 * @see com.kyj.service.EchartMapService#selectMap4()
	 */
	@Override
	public Option selectMap4() throws Exception {
		EchartMap3Example echartMap3Example = new EchartMap3Example();
		EchartMap3Example.Criteria criteria = echartMap3Example.createCriteria();
		criteria.andStartCityIsNotNull();
		criteria.andEndCityIsNotNull();
		List<EchartMap3> listCity = echartMap3Mapper.selectByExample(echartMap3Example);
		
		EchartMap4Example echartMap4Example = new EchartMap4Example();
		EchartMap4Example.Criteria criteria4 = echartMap4Example.createCriteria();
		criteria4.andCityNameIsNotNull();
		List<EchartMap4> listCitySite = echartMap4Mapper.selectByExample(echartMap4Example);
		
		Option option = new Option();
		/**
		 * 开始构造地图
		 */
		option.backgroundColor("#ECF5FF").color("gold","aqua","lime");
		//option.backgroundColor("#1b1b1b").color("gold","aqua","lime");
		option.title().text("分拨中心发件量").subtext("数据纯属虚构").x(X.center).textStyle().color("#1b1b1b");
		option.tooltip(Trigger.item);
		option.tooltip().formatter("{b}");
		// 设置图例,居中底部显示，显示边框
		option.legend().data("北京 Top10", "上海 Top10", "广州 Top10").selectedMode("single").orient(Orient.vertical).selected("上海 Top10" ,false).selected("广州 Top10" ,false).x(X.left);
		option.legend().textStyle().color("#1b1b1b");
		option.dataRange().calculable(true).color("#ff3333", "orange", "yellow","lime","aqua").max(100).min(70).textStyle().color("#fff");
		
		option.toolbox().show(true).orient(Orient.vertical)
		.feature(Tool.mark, Tool.dataView, Tool.restore, Tool.saveAsImage).x(X.right).y(Y.center);
		/*option.roamController().show(true).mapTypeControl("china", true).x(X.right);*/
		
		
		
		
		ItemStyle dataStyleMap = new ItemStyle();
		// dataStyleMap.normal().barBorderColor("rgba(100,149,237,1)").borderWidth(1).areaStyle().color("#AAAAFF");
		dataStyleMap.normal().borderColor("#B15BFF");
		dataStyleMap.normal().color("#AAAAFF");
		com.github.abel533.echarts.series.Map map = new com.github.abel533.echarts.series.Map("全国");
		map.mapType("china").roam(true).hoverable(false).selectedMode("single").itemStyle(dataStyleMap);
		map.data(new Data());
		ItemStyle dataStyleMarkLine = new ItemStyle();
		dataStyleMarkLine.normal().barBorderColor("rgba(30,144,255,0.5)").borderWidth(1).color("#6C6C6C");
		MarkLine markLine = new MarkLine();
		markLine.smooth(true).symbolSize(1).itemStyle(dataStyleMarkLine);
		markLine.symbol(new Symbol[]{Symbol.none,Symbol.circle});
		//markLine.symbol("none", "circle");
		
		// 根据获取的数据赋值
		for (EchartMap3 echartMap3 : listCity) {
			markLine.data().add(new Data[]{new Data(echartMap3.getStartCity()), new Data(echartMap3.getEndCity())});
		}
		map.setMarkLine(markLine);
		//markLine.data(listData);
		
		GeoCoord geoCoord = new GeoCoord();
		for (EchartMap4 echartMap4 : listCitySite) {
			geoCoord.put(echartMap4.getCityName(), echartMap4.getLongitudeNum(), echartMap4.getLatitudeNum());
		}
		map.setGeoCoord(geoCoord);
		/**
		 * 北京
		 */
		com.github.abel533.echarts.series.Map map1 = new com.github.abel533.echarts.series.Map("北京 Top10");
		map1.mapType("china");
		map1.data(new Data());
		ItemStyle dataStyleMarkLine1 = new ItemStyle();
		dataStyleMarkLine1.normal().borderWidth(1).lineStyle().type(LineType.solid);
		dataStyleMarkLine1.normal().lineStyle().shadowBlur(10);
		MarkLine markLine1 = new MarkLine();
		markLine1.smooth(true).effect().show(true).scaleSize(1).period(30).color("#fff").shadowBlur(10);
		markLine1.itemStyle(dataStyleMarkLine1);
		
		ItemStyle dataStyleMarkPoint1 = new ItemStyle();
		dataStyleMarkPoint1.normal().label().show(false);
		dataStyleMarkPoint1.emphasis().label().position("top");
		MarkPoint markPoint1 = new MarkPoint();
		markPoint1.symbol("emptyCircle").symbolSize("(function(v){return return 10 + v/10;})()").effect().show(true).shadowBlur(0);
		markPoint1.itemStyle(dataStyleMarkPoint1);
		
		
		/**
		 * 上海
		 */
		com.github.abel533.echarts.series.Map map2 = new com.github.abel533.echarts.series.Map("上海 Top10");
		map2.mapType("china");
		map2.data(new Data());
		ItemStyle dataStyleMarkLine2 = new ItemStyle();
		dataStyleMarkLine2.normal().borderWidth(1).lineStyle().type(LineType.solid);
		dataStyleMarkLine2.normal().lineStyle().shadowBlur(10);
		MarkLine markLine2 = new MarkLine();
		markLine2.smooth(true).effect().show(true).scaleSize(1).period(30).color("#fff").shadowBlur(10);
		markLine2.itemStyle(dataStyleMarkLine2);
		
		ItemStyle dataStyleMarkPoint2 = new ItemStyle();
		dataStyleMarkPoint2.normal().label().show(false);
		dataStyleMarkPoint2.emphasis().label().position("top");
		MarkPoint markPoint2 = new MarkPoint();
		markPoint2.symbol("emptyCircle").symbolSize("(function(v){return return 10 + v/10;})()").effect().show(true).shadowBlur(0);
		markPoint2.itemStyle(dataStyleMarkPoint1);
		
		/**
		 * 广州
		 */
		com.github.abel533.echarts.series.Map map3 = new com.github.abel533.echarts.series.Map("广州 Top10");
		map3.mapType("china");
		map3.data(new Data());
		ItemStyle dataStyleMarkLine3 = new ItemStyle();
		dataStyleMarkLine3.normal().borderWidth(1).lineStyle().type(LineType.solid);
		dataStyleMarkLine3.normal().lineStyle().shadowBlur(10);
		MarkLine markLine3 = new MarkLine();
		markLine3.smooth(true).effect().show(true).scaleSize(1).period(30).color("#fff").shadowBlur(10);
		markLine3.itemStyle(dataStyleMarkLine3);
		
		ItemStyle dataStyleMarkPoint3 = new ItemStyle();
		dataStyleMarkPoint3.normal().label().show(false);
		dataStyleMarkPoint3.emphasis().label().position("top");
		MarkPoint markPoint3 = new MarkPoint();
		markPoint3.symbol("emptyCircle").symbolSize("(function(v){return return 10 + v/10;})()").effect().show(true).shadowBlur(0);
		markPoint3.itemStyle(dataStyleMarkPoint3);
		//markLine.symbol("none", "circle");
		// 根据获取的数据赋值
		List<EchartMap3> listCityTop = echartMap3CustomMapper.selectTOP10();
		for (EchartMap3 echartMap3Top : listCityTop) {
			if("北京".equals(echartMap3Top.getStartCity())){
				markLine1.data().add(new Data[]{new Data(echartMap3Top.getStartCity()), new Data(echartMap3Top.getEndCity(),echartMap3Top.getShipmentTotal())});
				markPoint1.data(new Data(echartMap3Top.getEndCity(),echartMap3Top.getShipmentTotal()));
			}else if("上海".equals(echartMap3Top.getStartCity())){
				markLine2.data().add(new Data[]{new Data(echartMap3Top.getStartCity()), new Data(echartMap3Top.getEndCity(),echartMap3Top.getShipmentTotal())});
				markPoint2.data(new Data(echartMap3Top.getEndCity(),echartMap3Top.getShipmentTotal()));
			}else if("广州".equals(echartMap3Top.getStartCity())){
				markLine3.data().add(new Data[]{new Data(echartMap3Top.getStartCity()), new Data(echartMap3Top.getEndCity(),echartMap3Top.getShipmentTotal())});
				markPoint3.data(new Data(echartMap3Top.getEndCity(),echartMap3Top.getShipmentTotal()));
			}
		}
		map1.setMarkLine(markLine1);
		map1.setMarkPoint(markPoint1);
		map2.setMarkLine(markLine2);
		map2.setMarkPoint(markPoint2);
		map3.setMarkLine(markLine3);
		map3.setMarkPoint(markPoint3);
		
		
		// 设置数据
		option.series(map,map1,map2,map3);
		//option.series(map);
		return option;
	}
	
	@Override
	public Option selectMap5() throws Exception {
		EchartMap3Example echartMap3Example = new EchartMap3Example();
		EchartMap3Example.Criteria criteria = echartMap3Example.createCriteria();
		criteria.andStartCityIsNotNull();
		criteria.andEndCityIsNotNull();
		List<EchartMap3> listCity = echartMap3Mapper.selectByExample(echartMap3Example);
		
		EchartMap4Example echartMap4Example = new EchartMap4Example();
		EchartMap4Example.Criteria criteria4 = echartMap4Example.createCriteria();
		criteria4.andCityNameIsNotNull();
		List<EchartMap4> listCitySite = echartMap4Mapper.selectByExample(echartMap4Example);
		
		Option option = new Option();
		
		/**
		 * 开始构造地图中的数据
		 */
		
		option.toolbox().show(true).orient(Orient.vertical).feature(Tool.mark, Tool.dataView, Tool.restore, Tool.saveAsImage).x(X.right).y(Y.center);
		
		com.github.abel533.echarts.series.Map map = new com.github.abel533.echarts.series.Map("全国");
		MarkLine markLine = new MarkLine();
		GeoCoord geoCoord = new GeoCoord();
		
		// 根据获取的数据赋值
		for (EchartMap3 echartMap3 : listCity) {
			markLine.data().add(new Data[]{new Data(echartMap3.getStartCity()), new Data(echartMap3.getEndCity())});
		}
		map.setMarkLine(markLine);
		
		for (EchartMap4 echartMap4 : listCitySite) {
			geoCoord.put(echartMap4.getCityName(), echartMap4.getLongitudeNum(), echartMap4.getLatitudeNum());
		}
		map.setGeoCoord(geoCoord);
		/**
		 * 北京
		 */
		com.github.abel533.echarts.series.Map map1 = new com.github.abel533.echarts.series.Map("北京 Top10");
		
		MarkLine markLine1 = new MarkLine();
		
		MarkPoint markPoint1 = new MarkPoint();
		
		
		/**
		 * 上海
		 */
		com.github.abel533.echarts.series.Map map2 = new com.github.abel533.echarts.series.Map("上海 Top10");
		MarkLine markLine2 = new MarkLine();
		MarkPoint markPoint2 = new MarkPoint();
		
		/**
		 * 广州
		 */
		com.github.abel533.echarts.series.Map map3 = new com.github.abel533.echarts.series.Map("广州 Top10");
		MarkLine markLine3 = new MarkLine();
		
		MarkPoint markPoint3 = new MarkPoint();
		//markLine.symbol("none", "circle");
		// 根据获取的数据赋值
		List<EchartMap3> listCityTop = echartMap3CustomMapper.selectTOP10();
		for (EchartMap3 echartMap3Top : listCityTop) {
			if("北京".equals(echartMap3Top.getStartCity())){
				markLine1.data().add(new Data[]{new Data(echartMap3Top.getStartCity()), new Data(echartMap3Top.getEndCity(),echartMap3Top.getShipmentTotal())});
				markPoint1.data(new Data(echartMap3Top.getEndCity(),echartMap3Top.getShipmentTotal()));
			}else if("上海".equals(echartMap3Top.getStartCity())){
				markLine2.data().add(new Data[]{new Data(echartMap3Top.getStartCity()), new Data(echartMap3Top.getEndCity(),echartMap3Top.getShipmentTotal())});
				markPoint2.data(new Data(echartMap3Top.getEndCity(),echartMap3Top.getShipmentTotal()));
			}else if("广州".equals(echartMap3Top.getStartCity())){
				markLine3.data().add(new Data[]{new Data(echartMap3Top.getStartCity()), new Data(echartMap3Top.getEndCity(),echartMap3Top.getShipmentTotal())});
				markPoint3.data(new Data(echartMap3Top.getEndCity(),echartMap3Top.getShipmentTotal()));
			}
		}
		map1.setMarkLine(markLine1);
		map1.setMarkPoint(markPoint1);
		map2.setMarkLine(markLine2);
		map2.setMarkPoint(markPoint2);
		map3.setMarkLine(markLine3);
		map3.setMarkPoint(markPoint3);
		
		
		// 设置数据
		option.series(map,map1,map2,map3);
		return option;
	}
}
