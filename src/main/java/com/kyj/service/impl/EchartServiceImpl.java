package com.kyj.service.impl;

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
import com.github.abel533.echarts.code.Magic;
import com.github.abel533.echarts.code.Orient;
import com.github.abel533.echarts.code.Tool;
import com.github.abel533.echarts.code.Trigger;
import com.github.abel533.echarts.code.X;
import com.github.abel533.echarts.code.Y;
import com.github.abel533.echarts.data.Data;
import com.github.abel533.echarts.data.PieData;
import com.github.abel533.echarts.feature.MagicType;
import com.github.abel533.echarts.series.Bar;
import com.github.abel533.echarts.series.Line;
import com.github.abel533.echarts.series.Pie;
import com.github.abel533.echarts.style.ItemStyle;
import com.github.abel533.echarts.style.LineStyle;
import com.kyj.mapper.EchartMap1Mapper;
import com.kyj.mapper.EchartTest1Mapper;
import com.kyj.mapper.EchartTest2Mapper;
import com.kyj.po.EchartMap1;
import com.kyj.po.EchartMap1Example;
import com.kyj.po.EchartTest1;
import com.kyj.po.EchartTest1Example;
import com.kyj.po.EchartTest2;
import com.kyj.po.EchartTest2Example;
import com.kyj.service.EchartService;

@Service
public class EchartServiceImpl implements EchartService {

	@Autowired
	private EchartTest1Mapper echartMapper;
	@Autowired
	private EchartTest2Mapper echartMapper2;

	@Override
	public Option selectByExample_zhe1() throws Exception {
		EchartTest2Example echartTest2Example = new EchartTest2Example();
		EchartTest2Example.Criteria criteria = echartTest2Example.createCriteria();
		criteria.andIdIsNotNull();
		// criteria.andSysNameEqualTo("C9报表系统");
		Option option = new Option();
		List<EchartTest2> list = echartMapper2.selectByExample(echartTest2Example);
		// 设置图表标题，并且居中显示
		option.title().text("最近7天访问量图表").x(X.center);

		// 设置图例,居中底部显示，显示边框
		option.legend().data("C9报表系统访问量", "一站式系统访问量").x(X.center).y(Y.bottom).borderWidth(1);
		option.toolbox().show(true).feature(Tool.mark, Tool.dataView, new MagicType(Magic.line, Magic.bar),
				Tool.restore, Tool.saveAsImage);
		// 设置y轴为值轴，并且不显示y轴，最大值设置4000，最小值1000
		option.yAxis(new ValueAxis().name("IP").axisLine(new AxisLine().show(true).lineStyle(new LineStyle().width(0)))
				.max(4000).min(1000));

		// 创建类目轴，并且不显示竖着的分割线，onZero=false
		CategoryAxis categoryAxis = new CategoryAxis().splitLine(new SplitLine().show(false))
				.axisLine(new AxisLine().onZero(false));

		// 不显示表格边框，就是围着图标的方框
		option.grid().borderWidth(0);
		Line line = new Line("一站式系统访问量").smooth(true);
		Line line2 = new Line("C9报表系统访问量").smooth(true);

		// 根据获取的数据赋值
		for (EchartTest2 echartTest2 : list) {
			// 增加类目，值为日期

			if ("C9报表系统".equals(echartTest2.getSysName())) {
				categoryAxis.data(echartTest2.getAccessDate());
				// 日期对应的数据
				line2.data(echartTest2.getAccessTotal());
			} else {
				line.data(echartTest2.getAccessTotal());
			}
		}

		// 设置x轴为类目轴
		option.xAxis(categoryAxis);

		// 设置数据
		option.series(line, line2);

		return option;
	}

	@Override
	public Option selectByExample_shan() throws Exception {
		EchartTest1Example echartTest1Example = new EchartTest1Example();
		EchartTest1Example.Criteria criteria = echartTest1Example.createCriteria();
		criteria.andIdIsNotNull();
		List<EchartTest1> list = echartMapper.selectByExample(echartTest1Example);
		// 地址：http://echarts.baidu.com/doc/example/pie6.html
		ItemStyle dataStyle = new ItemStyle();
		dataStyle.normal().label(new Label().show(true)).labelLine().show(true);
		ItemStyle dataStyle1 = new ItemStyle();
		dataStyle1.normal().label(new Label().show(true)).labelLine().show(true);
		ItemStyle dataStyle2 = new ItemStyle();
		dataStyle2.normal().label(new Label().show(true)).labelLine().show(true);

		ItemStyle placeHolderStyle = new ItemStyle();
		placeHolderStyle.normal().color("rgba(0,0,0,0)").label(new Label().show(false)).labelLine().show(false);
		placeHolderStyle.emphasis().color("rgba(0,0,0,0)");
		ItemStyle placeHolderStyle1 = new ItemStyle();
		placeHolderStyle1.normal().color("rgba(0,0,0,0)").label(new Label().show(false)).labelLine().show(false);
		placeHolderStyle1.emphasis().color("rgba(0,0,0,0)");
		ItemStyle placeHolderStyle2 = new ItemStyle();
		placeHolderStyle2.normal().color("rgba(0,0,0,0)").label(new Label().show(false)).labelLine().show(false);
		placeHolderStyle2.emphasis().color("rgba(0,0,0,0)");

		Option option = new Option();
		option.title().text("你幸福吗？").subtext("From ExcelHome").sublink("http://www.baidu.com").x(X.center).y(Y.center)
				.itemGap(20).textStyle().color("rgba(30,144,255,0.8)").fontFamily("微软雅黑").fontSize(35)
				.fontWeight("bolder");
		option.tooltip().show(true).formatter("{a} <br/>{b} : {c} ({d}%)");
		option.legend().orient(Orient.vertical)
				.x("(function(){return document.getElementById('main').offsetWidth / 2;})()").y(56).itemGap(12)
				.data("68%的人表示过的不错", "29%的人表示生活压力很大", "3%的人表示“我姓曾”");
		option.toolbox().show(true).feature(Tool.mark, Tool.dataView, Tool.restore, Tool.saveAsImage);

		Pie p1 = new Pie("1");
		p1.clockWise(false).radius(125, 150).itemStyle(dataStyle).data(new Data("68%的人表示过的不错", 68),
				new Data("invisible", 32).itemStyle(placeHolderStyle));

		Pie p2 = new Pie("2");
		p2.clockWise(false).radius(100, 125).itemStyle(dataStyle1).data(new Data("29%的人表示生活压力很大", 29),
				new Data("invisible", 71).itemStyle(placeHolderStyle1));

		Pie p3 = new Pie("3");
		p3.clockWise(false).radius(75, 100).itemStyle(dataStyle2).data(new Data("3%的人表示“我姓曾”", 3),
				new Data("invisible", 97).itemStyle(placeHolderStyle2));

		option.series(p1, p2, p3);

		return option;
	}

	@Override
	public Option selectByExample_zhe() throws Exception {
		EchartTest1Example echartTest1Example = new EchartTest1Example();
		EchartTest1Example.Criteria criteria = echartTest1Example.createCriteria();
		criteria.andIdIsNotNull();
		List<EchartTest1> list = echartMapper.selectByExample(echartTest1Example);
		Option option = new Option();
		// 地址:http://echarts.baidu.com/doc/example/line5.html
		option.legend("高度(km)与气温(°C)变化关系");

		option.toolbox().show(true).feature(Tool.mark, Tool.dataView, new MagicType(Magic.line, Magic.bar),
				Tool.restore, Tool.saveAsImage);

		option.calculable(true);
		option.tooltip().trigger(Trigger.axis).formatter("Temperature : <br/>{b}km : {c}°C");

		ValueAxis valueAxis = new ValueAxis();
		valueAxis.axisLabel().formatter("{value} °C");
		option.xAxis(valueAxis);

		CategoryAxis categoryAxis = new CategoryAxis();
		categoryAxis.axisLine().onZero(false);
		categoryAxis.axisLabel().formatter("{value} km");
		categoryAxis.boundaryGap(false);
		categoryAxis.data(0, 10, 20, 30, 40, 50, 60, 70, 80);
		option.yAxis(categoryAxis);

		Line line = new Line();
		line.smooth(true).name("高度(km)与气温(°C)变化关系").data(15, -50, -56.5, -46.5, -22.1, -2.5, -27.7, -55.7, -76.5)
				.itemStyle().normal().lineStyle().shadowColor("rgba(0,0,0,0.4)");
		option.series(line);

		return option;
	}

	@Override
	public Option selectByExample_zhu() throws Exception {
		EchartTest1Example echartTest1Example = new EchartTest1Example();
		EchartTest1Example.Criteria criteria = echartTest1Example.createCriteria();
		criteria.andIdIsNotNull();
		List<EchartTest1> list = echartMapper.selectByExample(echartTest1Example);
		Option option = new Option();
		option.title("商品信息", "数据库测试数据").tooltip(Trigger.axis).legend("价格").legend("数量");
		/*
		 * Toolbox toolbox = new Toolbox(); toolbox.setShow(true);
		 * toolbox.setFeature();; option.setToolbox(toolbox);
		 */
		// 横轴为值轴
		option.yAxis(new ValueAxis().boundaryGap(0d, 0.01));
		// 创建类目轴
		CategoryAxis category = new CategoryAxis();
		// 柱状数据
		Bar bar1 = new Bar("价格");
		Bar bar2 = new Bar("数量");
		// 饼图数据
		// Pie pie = new Pie("金额（元）");
		// 循环数据
		for (EchartTest1 echartTest1 : list) {
			// 设置类目
			category.data(echartTest1.getProductName());
			// 类目对应的柱状图
			bar1.data(echartTest1.getProductPrice());
			bar2.data(echartTest1.getProductTotal());
		}
		// 设置类目轴
		option.xAxis(category);
		// 设置数据
		option.series(bar1, bar2);
		// 由于名字过长，图表距离左侧距离设置180，关于grid可以看ECharts的官方文档
		option.grid().x(180);
		// 返回Option

		return option;
	}

	@Override
	public Option selectByExample() throws Exception {
		EchartTest1Example echartTest1Example = new EchartTest1Example();
		EchartTest1Example.Criteria criteria = echartTest1Example.createCriteria();
		criteria.andIdIsNotNull();
		List<EchartTest1> list = echartMapper.selectByExample(echartTest1Example);
		Option option = new Option();
		option.title("商品价格", "数据库测试数据").tooltip(Trigger.axis).legend("金额（元）");
		// 横轴为值轴
		option.xAxis(new ValueAxis().boundaryGap(0d, 0.01));
		// 创建类目轴
		CategoryAxis category = new CategoryAxis();
		// 柱状数据
		Bar bar = new Bar("金额（元）");
		// 饼图数据
		Pie pie = new Pie("金额（元）");
		// 循环数据
		for (EchartTest1 echartTest1 : list) {
			// 设置类目
			category.data(echartTest1.getProductName());
			// 类目对应的柱状图
			bar.data(echartTest1.getProductPrice());
			// 饼图数据
			pie.data(new PieData(echartTest1.getProductName().toString(), echartTest1.getProductPrice()));
		}
		// 设置类目轴
		option.yAxis(category);
		// 饼图的圆心和半径
		pie.center(1100, 400).radius(100);
		// 设置数据
		option.series(bar, pie);
		// 由于药品名字过长，图表距离左侧距离设置180，关于grid可以看ECharts的官方文档
		option.grid().x(180);
		// 返回Option

		return option;
	}

	@Override
	public Option selectRemoveCauses() throws Exception {
		/*
		 * /查询前20 PageHelper.startPage(1, 20, false); //数据库查询获取统计数据
		 * List<Map<String, Object>> list = kc22Mapper.selectRemoveCauses();
		 * //为了数据从大到小排列，这里需要倒叙 Collections.sort(list, new Comparator<Map<String,
		 * Object>>() {
		 * 
		 * @Override public int compare(Map<String, Object> o1, Map<String,
		 * Object> o2) { return -1; } });
		 */
		// String
		// jsonStr="{['NAME':'电脑','TOTAL':'500'],['NAME':'手机','TOTAL':'300'],['NAME':'平板','TOTAL':'400']}";

		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Map<String, Object> map1 = new HashMap<String, Object>();
		map1.put("NAME", "电脑");
		map1.put("TOTAL", 500);
		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("NAME", "手机");
		map2.put("TOTAL", 300);
		Map<String, Object> map3 = new HashMap<String, Object>();
		map3.put("NAME", "平板");
		map3.put("TOTAL", 400);
		list.add(map1);
		list.add(map2);
		list.add(map3);
		// 创建Option
		Option option = new Option();
		option.title("剔除药品").tooltip(Trigger.axis).legend("金额（元）");
		// 横轴为值轴
		option.xAxis(new ValueAxis().boundaryGap(0d, 0.01));
		// 创建类目轴
		CategoryAxis category = new CategoryAxis();
		// 柱状数据
		Bar bar = new Bar("金额（元）");
		// 饼图数据
		Pie pie = new Pie("金额（元）");
		// 循环数据
		for (Map<String, Object> objectMap : list) {
			// 设置类目
			category.data(objectMap.get("NAME"));
			// 类目对应的柱状图
			bar.data(objectMap.get("TOTAL"));
			// 饼图数据
			pie.data(new PieData(objectMap.get("NAME").toString(), objectMap.get("TOTAL")));
		}
		// 设置类目轴
		option.yAxis(category);
		// 饼图的圆心和半径
		pie.center(900, 380).radius(100);
		// 设置数据
		option.series(bar, pie);
		// 由于药品名字过长，图表距离左侧距离设置180，关于grid可以看ECharts的官方文档
		option.grid().x(180);
		// 返回Option

		return option;
	}
}
