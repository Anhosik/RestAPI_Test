package kdjsystem.mllink.mapper;

import kdjsystem.mllink.dto.sms.SmsInf;
import kdjsystem.mllink.dto.user.UserInf;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Optional;

@Mapper
public interface SmsMapper {

    @Select("SELECT COMPNO, SMSALIASE, SMSNO, SMSCHGAMT, SMSUSEAMT, SMSBALANCE, CONTPRICE, SERIALNO, USERID, SMSPRICE, LMSPRICE FROM SMSCHARGEMST WHERE USERID = #{userid} ")
    Optional<SmsInf.RequestSmsCharge> findBySmsCharge(@Param("userid") String userid);

    @Insert("INSERT INTO SMSCHARGEMST ( COMPNO , USERID , SERIALNO , SMSPRICE , LMSPRICE , SMSALIASE, SMSCHGAMT, SMSUSEAMT, SMSBALANCE, CONTPRICE)   " +
            "VALUES (#{compno}, #{userid} , 0 , 20 , 53 , #{smsaliase} , 0, 0, 0, 13)")
    int setSmsChargeMst(@Param("compno") Integer compno, @Param("userid") String userid,@Param("smsaliase") String smsaliase);

    @Update("update SMSCHARGEMST set SMSUSEAMT= #{smsuseamt}, SMSBALANCE= #{smsbalance}, SERIALNO= #{serialno} where userid = #{userid}")
    int setSmsChargeMstUpdate(@Param("userid") String userid,@Param("smsuseamt") Integer smsuseamt,@Param("smsbalance") Integer smsbalance
            ,@Param("serialno") Integer serialno);

    @Select("select COMPNO,SMSALIASE, SMSNO,SMSCHGAMT, SMSUSEAMT,SMSBALANCE,CONTPRICE, SERIALNO, USERID,SMSPRICE, LMSPRICE from SMSCHARGEMST " +
            "where USERID= #{userid} ")
    SmsInf.RequestSmsChargeMst smsSelect(@Param("userid") String userid);

    @Insert("insert into SMSCHARGEDTL (COMPNO,ALIASESEQ, TOCONTACT,CONTENTS, SENTDATE, TIMESPENT,SMSTYPE,USERID) values(#{compno}, #{aliaseseq}, #{tocontact}, #{contents}, " +
            "#{sentdate}, #{timespent}, #{smstype}, #{userid}) ")
    int setSmsChargeDtl(@Param("compno") Integer compno, @Param("aliaseseq") Integer aliaseseq,@Param("tocontact") String tocontact,@Param("contents") String contents
            ,@Param("sentdate") String sentdate,@Param("timespent") String timespent,@Param("smstype") String smstype,@Param("userid") String userid);

    @Update("update SMSCHARGEMST set SERIALNO= #{serialno} where userid = #{userid}")
    int setSmsChargeSerial(@Param("userid") String userid,@Param("serialno") Integer serialno);

    @Select("SELECT COMPNO, SMSALIASE, SMSNO, SMSCHGAMT, SMSUSEAMT, SMSBALANCE, CONTPRICE, SERIALNO, USERID, SMSPRICE, LMSPRICE FROM SMSCHARGEMST WHERE COMPNO = #{compno} AND USERID = #{userid} ")
    Optional<SmsInf.RequestSmsChargeMst> findBySmscheck(@Param("compno") Integer compno, @Param("userid") String userid);

    @Update("update SMSCHARGEMST set SMSCHGAMT= #{smschgamt}, SMSBALANCE= #{smsbalance} where COMPNO = #{compno} and userid = #{userid}")
    int setSmsPriceUpdate(@Param("compno") Integer compno, @Param("userid") String userid,@Param("smschgamt") Integer smschgamt,@Param("smsbalance") Integer smsbalance);

    @Select("SELECT COMPNO, ALIASESEQ, TOCONTACT, CONTENTS, SENTDATE, TIMESPENT, SMSTYPE FROM SMSCHARGEDTL WHERE USERID = #{userid} ORDER BY SENTDATE DESC, TIMESPENT DESC;")
    List<SmsInf.RequestSmsChargeDtl> smschargeDtlAll(@Param("userid") String userid);

    @Select("SELECT ALIASESEQ, TOCONTACT ,CONTENTS ,SENTDATE ,TIMESPENT ,smstype from SMSCHARGEDTL where USERID = #{userid} and SENTDATE >= #{orddtFrom} and SENTDATE <= #{orddtTo} and ALIASESEQ LIKE #{contents} ORDER BY SENTDATE DESC, TIMESPENT DESC")
    List<SmsInf.RequestSmsChargeDtl> smschargeDtlseq(@Param("userid") String userid, @Param("orddtFrom") String orddtFrom, @Param("orddtTo") String orddtTo, @Param("contents") String contents);

    @Select("SELECT ALIASESEQ, TOCONTACT ,CONTENTS ,SENTDATE ,TIMESPENT ,smstype from SMSCHARGEDTL where USERID = #{userid} and SENTDATE >= #{orddtFrom} and SENTDATE <= #{orddtTo} and TOCONTACT LIKE #{contents} ORDER BY SENTDATE DESC, TIMESPENT DESC")
    List<SmsInf.RequestSmsChargeDtl> smschargeDtltocontact(@Param("userid") String userid, @Param("orddtFrom") String orddtFrom, @Param("orddtTo") String orddtTo, @Param("contents") String contents);

    @Select("SELECT ALIASESEQ, TOCONTACT ,CONTENTS ,SENTDATE ,TIMESPENT ,smstype from SMSCHARGEDTL where USERID = #{userid} and SENTDATE >= #{orddtFrom} and SENTDATE <= #{orddtTo} and CONTENTS LIKE #{contents} ORDER BY SENTDATE DESC, TIMESPENT DESC")
    List<SmsInf.RequestSmsChargeDtl> smschargeDtlcontents(@Param("userid") String userid, @Param("orddtFrom") String orddtFrom, @Param("orddtTo") String orddtTo, @Param("contents") String contents);

}
