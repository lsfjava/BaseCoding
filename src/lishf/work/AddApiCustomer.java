package lishf.work;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import lishf.work.utils.PropertiesUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.UUID;

/**
 * 开通API用户
 * Created by Administrator on 2017\8\21
 */
public class AddApiCustomer {

    private static long channelTableId;
    private static long addrTableId;
    private static long keyInfoTableId;
    private static long tradeTableId;
    private static long pushTableId;


    public static void main(String[] args){

        // 1、生成32位客户密匙
        String key = generate32key();

        // 2、生成系统对接登记表 TODO

        // 3、获得数据库参数
        getDb2params("test");

        // 3、生成脚本
        generateSql("UserId","机构ID","客户名称","TEST","http://www.baidu.com", key);




    }

    private static String generate32key(){
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        System.out.println("随机客户密匙：" + uuid);
        return uuid;
    }

    /**
     * 获得数据库参数
     * @param type 数据库: test-准生产， dev-测试环境
     */
    private static void getDb2params(String type){
        try {
            Class.forName("com.ibm.db2.jcc.DB2Driver");
            // 数据库参数
            String url;
            String name;
            String password;
            if ( "test".equals(type) ) {
                // 准生产环境配置
                url = "jdbc:db2://10.1.3.1:50001/hdzx";
                name = "front";
                password = "front_dbadmin";
            } else if ( "dev".equals(type) ) {
                // 开发测试环境配置
                url = "jdbc:db2://10.0.1.170:50000/toolsdb:currentSchema=FRONTDB;";
                name = "db2admin";
                password = "flyvideo";
            } else {
                // 参数错误
                System.out.println("参数错误");
                return;
            }
            // 连接数据库进行查询
            Connection conn = DriverManager.getConnection(url, name, password);
            PreparedStatement ps=conn.prepareStatement( "select max(ID) as max from B_CFGDEF_CHANL where ID like '5%'");
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                System.out.println( "渠道表最大ID：" + rs.getLong("max"));
                channelTableId = rs.getLong("max") + 1;
            }

            ps=conn.prepareStatement( "select max(ID) as max from B_CFGDEF_FNTTRNADDR");
            rs=ps.executeQuery();
            while (rs.next()){
                System.out.println( "地址表最大ID：" + rs.getLong("max"));
                addrTableId = rs.getLong("max") + 1;
            }

            ps=conn.prepareStatement( "select max(ID) as max from B_CFGDEF_FNTKEYINFO");
            rs=ps.executeQuery();
            while (rs.next()){
                System.out.println( "账号表最大ID：" + rs.getLong("max"));
                keyInfoTableId = rs.getLong("max") + 1;
            }

            ps=conn.prepareStatement( "select max(ID) as max from B_CFGDEF_CHNLTRD");
            rs=ps.executeQuery();
            while (rs.next()){
                System.out.println( "交易表最大ID：" + rs.getLong("max"));
                tradeTableId = rs.getLong("max") + 1;
            }

            ps=conn.prepareStatement( "select max(ID) as max from B_CFGDEF_RESPUSH");
            rs=ps.executeQuery();
            while (rs.next()){
                System.out.println( "推送表最大ID：" + rs.getLong("max"));
                pushTableId = rs.getLong("max") + 1;
            }

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void generateSql(String userId, String orgId, String name, String code, String addr, String key){
        System.out.println(":::::::::::::::::::SQL:::::::::::::::::");
        System.out.println("---- 账号id：" + userId + " ,机构号：" + orgId + " ,渠道号：" + channelTableId);
        System.out.println("---- 产品明细表(需要手动修改!!!) ----");
        System.out.println("INSERT INTO B_CFGREF_PRDDETIL (ID, PRDCOD, PRDNAM, TRNCOD, PRDTYP, DAYEXPCNT, MONEXPCNT, MON3EXPCNT, WARNFREQ, STA) " +
                "VALUES ('" + code + "0001P0000011','" + code + "0002','反欺诈固定策略','P0000011',null, '', '', '', '', '1' );");
        System.out.println("INSERT INTO B_CFGREF_PRDDETIL (ID, PRDCOD, PRDNAM, TRNCOD, PRDTYP, DAYEXPCNT, MONEXPCNT, MON3EXPCNT, WARNFREQ, STA) " +
                "VALUES ('" + code + "0001P0000015','" + code + "0002','反欺诈固定策略','P0000015',null, '', '', '', '', '1' );");
        System.out.println("INSERT INTO B_CFGREF_PRDDETIL (ID, PRDCOD, PRDNAM, TRNCOD, PRDTYP, DAYEXPCNT, MONEXPCNT, MON3EXPCNT, WARNFREQ, STA) " +
                "VALUES ('" + code + "0001P0000029','" + code + "0002','反欺诈固定策略','P0000029',null, '', '', '', '', '1' );");
        System.out.println("----- 渠道配置 -----");
        System.out.println("INSERT INTO B_CFGDEF_CHANL (ID, CHNLCOD, CHNLNAM, CHNLTYPE, STA, MEMO) " +
                "VALUES ('" + channelTableId + "', '" + channelTableId + "', '" + name + "', '1', '1', '" + name + "');");
        System.out.println("----- 地址配置 -----");
        System.out.println("INSERT INTO B_CFGDEF_FNTTRNADDR (ID, TRNADDRCOD, ADDRNAM, PROTOCOL, CONECTFLG, CONUSR, CONPASS, TRNADDR, ADDR1, ADDR2, STA, MEMO) " +
                "VALUES ('" + addrTableId + "', '" + code + "000001', '" + name + "', '02', '1', null, null, '" + addr + "', null, null, '1', '" + name + "');");
        System.out.println("----- 下游密钥配置 -----");
        System.out.println("INSERT INTO B_CFGDEF_FNTKEYINFO (ID, KEYCOD, CHNLCOD, KEYVAL, KEYVP, STA, ADDRCOD) " +
                "VALUES ('" + keyInfoTableId + "', '" + keyInfoTableId + "', '" + channelTableId + "', '{\"vector\":\"sinoway8\",\"key\":\"" + key + "\"}', '99999999', '1', '');");
        System.out.println("----- 交易配置 -----");
        System.out.println("INSERT INTO B_CFGDEF_CHNLTRD (ID, INTRNCOD, PRDCOD, CHNLCOD, INTERMODE, RESGETTYPE, RESRESTYPE, RESRESURL, RESGETURL, REQURL, TRNTYP, REQQUE, RESQUE, DELOVER, DELOVERNUM, RESOVER, RESOVERNUM, BEANNAM) " +
                "VALUES ('" + tradeTableId + "', '', '', '" + channelTableId + "', '1', '1', '0', '', '', '', '2', 'req3', 'res3', '1800', '3', '60', '3', 'generalProductProcesser');");
        System.out.println("----- 推送配置 -----");
        System.out.println(" INSERT INTO B_CFGDEF_RESPUSH (ID, INCHNLCOD, USRID, PRDCOD, INTRNCOD, TRNTYP, OUTCHNLCOD, TRNADDRCOD, STA) " +
                "VALUES ('" + pushTableId + "', '" + channelTableId + "', '', '', '', '2', '" + channelTableId + "', '" + code + "000001', '1');");
    }



}
