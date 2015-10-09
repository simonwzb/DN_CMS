package com.fseer.dn.dn_cms.test.dao;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import org.junit.Test;

public class jdbcTest {

	@Test
	public void test() {
		String text = new String("<p style=\"text-align:center\"></p><p>　　文/王如晨<br /></p><p>　　真是一语成谶。</p><p>　　前几天在深圳跟业内朋友吃饭，席间谈到盒子以及生态话题，真是乐开怀。因为它已经可以做到平台化了，破解的盒子看起来真是非常棒，某家内容源如何优质等。</p><p>　　然后一个哥们就随口说了一句：“就是不知道广电方面啥时候动手。”广电真是一个神奇的部门。</p><p>　　广电这次的口吻里，有春秋笔法。它这次的选择性点名里有学问，虽有各种目的，但最核心的还是与电信的竞争。不过，我还是愿意一一来扯，呵呵。</p><p><strong>　　1、点名里有学问。</strong></p><p>　　首先从持牌方来说。你知道，一共有7家。央视CNTV、上海文广新闻传媒集团、浙江电视台和杭州广电华数集团、南方传媒、湖南电视台、中国国际广播电台(CIBN)以及中央人民电台。</p><p>　　根据总局下发的“关于立即关闭互联网电视终端产品中违规视频软件下载通道的函件”，它禁止浙江、上海两地电视盒预装未经审核的视频APP，并要求华数和百视通两家牌照商进行整改。</p><p>　　就持牌方来说，市场上拓展最快的也就是华数传媒与百视通。它们两家都是上市公司，业务拓展压力较大，尤其是华数传媒。它们在自己的优势地盘推广当然用力。其他几家牌照企业，基本没有多少声音。</p><p>　　但是，市场上，真正有大量出货的，还是天猫、小米、乐视等非广电系的盒子。</p><p>　　因此，在我看来，广电这是在“提纲挈领”、定点整顿。它没法直接监管小米、天猫们，拿牌照方开刀，将可管可控的压力转移给它们，它自己可以轻松些。这流露出一些尴尬：一共7家牌照方，除了这两家，其他都没多大声音，广电当初设立的这个牌照管制，其实很蹩脚。现在整顿，恐怕也有搞平衡的用意。</p><p><strong>　　2、背后有“污点证人”存在。</strong></p><p>　　过往几轮整顿背后，大都有所谓“污点证人”。从这次点名以及涉及的区域来看，市场上拓展但声音不大、未被点名的持牌方，一般存在这个嫌疑。</p><p>　　别怪我揣摩你。至少我觉得CNTV以往很善于用这招，跟它合作紧密的品牌乐视更善于钻研这学问。你知道，乐视现在主要力推它的互联网电视，而不是机顶盒。CNTV、乐视都没被点名。</p><p>　　而这次，总局提的虽是互联网电视终端，但没提OTT电视，主要针对的是盒子，而且集中在浙江与上海。其实，若是从总量上看，华数传媒的盒子虽然不少，但是它跟百视通的盒子整体出货总和，根本比不上非广电系的互联网企业，你仔细去体会里里面的门道吧。</p><p><strong>　　3、强化广电系内容竞争力</strong></p><p>　　不过，也别怪广电总局跟存在嫌疑的污点证人们。规则制订了，大家就得遵守，呵呵，虽然若严格按181号文来查，可以说，几乎没有一款真正合规的盒子。</p><p>　　即便带有选择性用意，但广电的举动确实有法可依，没的争议。这次整顿侧重的是内容，并没直白针对硬件终端，实际上，广电完全可以在内容与硬件方面同时整顿。</p><p>　　这就让人多思考内容方面了。你知道快播基本死掉了，内容监管，打击盗版的力度越来越大；你知道湖南那边的芒果TV独播不分销了，广电系已无法容忍过度开放局面下，体系内内容竞争力被瓦解、耗散，强化管控有利于强化体系内企业的竞争力。而且，国网已经成立，虽然无法一步整合，但体系内的局部动作肯定会越来越多，甚至跨区域整合已经有苗头。</p><p><strong>　　4、回击电信运营商渗透</strong></p><p>　　但是无论上面理由多少，广电的动作，若是归因起来，还是在于它与电信运营商的竞争。</p><p>　　过去，我们形容说，IPTV是电信插在广电心口窝的一把刀，但是相比它，开放的互联网的力量更强，它已经让广电的监管漏洞百出。</p><p>　　本来，广电想借OTT牌照两手抓监管，借此实现对电信运营商过顶传球，反击它的渗透，在国家“三网融合”的过程里占据主导地位。但目前来看，由于电信系拥有强大的基础设施，广电的用意有些尴尬，反而给了电信运营商更多渗透机会。毕竟开放的互联网企业主要依托它的通道，而不是先找广电。</p><p>　　可以这么说，新一轮竞争中，广电系若不能找到新的抓手，在三网融合的格局里，它的力量会继续被边缘化。我个人觉得，广电也只能从内容角度出手了，这个还算得上抓手，若从终端层面入手，所谓可观可控只会沦为口号。</p><p>　　不过，我们确实看到，互联网信息泛滥，里面夹杂着许多无良的部分，市场确实到了一个需要规范的阶段。我知道，新版292号文正在酝酿出台中，它应该更侧重针对互联网企业的监管，尤其是抑制BAT强大的渗透力量，它们的媒体属性越来越强，若它们不能自律，互联网信息服务领域，大树之下，真的寸草不生。但这已经超过了广电的管控范围与能力。</p>");
		int flag = 0;
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:3306/dn_cms_db?useUnicode=true&characterEncoding=utf-8", "root",
					"root");
			
			String sql = "INSERT INTO article(name,author,main_body,channel_id,crt_datetime) VALUES(?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "longtext");
			ps.setString(2, "aaaaa");
			ps.setString(3, text);
			ps.setInt(4, 1);
			Date date = new Date();
			Timestamp t = new Timestamp(date.getTime());
			ps.setTimestamp(5, t);
			flag = ps.executeUpdate();
			System.out.println(flag);
			ps.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		assertNotEquals(flag, 0);
	}

	
	
	
}
