package kdjsystem.mllink.mapper;

import kdjsystem.mllink.dto.user.UserInf;
import org.apache.ibatis.annotations.*;

import java.util.Optional;

@Mapper
public interface UserMapper {
    @Select("SELECT compno, email FROM userinf where compno=#{compno} and userid=#{userid}")
    UserInf.RequestLogin getUserProfile(@Param("compno") Integer compno, @Param("userid") String userid);

    @Select("SELECT A.COMPNO, C.COMPNM, A.USERID, A.USERNAM, A.USERPWD, A.EMAIL, A.PROGCD, A.USEYN, A.LTYPE, A.STARTUSE, A.ENDUSE, A.TELNO, A.PRICETYPE, A.BRANDCD ,B.SMSBALANCE,C.CUSTNO " +
            "FROM USERINF AS A JOIN SMSCHARGEMST AS B ON A.COMPNO = B.COMPNO AND A.USERID=B.USERID JOIN COMPANYINFO AS C ON A.COMPNO = C.COMPNO AND A.USERID=C.USERID where A.userid=#{userid}")
    Optional<UserInf.ResponseUseInf> findByUserId(@Param("userid") String userid);

    @Select("SELECT COMPNO, USERID, USERNAM, USERPWD, EMAIL, PROGCD, USEYN, LTYPE, STARTUSE, ENDUSE, PRICETYPE, BRANDCD FROM USERINF WHERE COMPNO = #{compno} AND USERID = #{userid}")
    Optional<UserInf.RequestUserInf> findByUserinf(@Param("compno") Integer compno, @Param("userid") String userid);

    @Insert("INSERT INTO USERINF ( COMPNO , USERID , USERNAM , USERPWD , EMAIL , STARTUSE , ENDUSE , PRICETYPE , TELNO,USEYN )  VALUES (#{compno}, #{userid} , #{usernam} ," +
            " #{userpwd} , #{email} , #{startuse} , #{enduse}, #{pricetype}, #{telno},'Y')")
    int setUserInf(@Param("compno") Integer compno, @Param("userid") String userid,@Param("usernam") String usernam,@Param("userpwd") String userpwd
            ,@Param("email") String email,@Param("startuse") String startuse,@Param("enduse") String enduse,@Param("pricetype") String pricetype,@Param("telno") String telno);

    @Update("UPDATE USERINF SET USERNAM = #{usernam} , USERPWD = #{userpwd} , EMAIL = #{email} WHERE COMPNO = #{compno} AND USERID = #{userid}")
    int setUserInfUpdate(@Param("compno") Integer compno, @Param("userid") String userid, @Param("usernam") String usernam,@Param("userpwd") String userpwd,@Param("email") String email);

    @Update("UPDATE USERINF SET LTYPE = #{ltype} WHERE COMPNO = #{compno} AND USERID = #{userid}")
    int setUserLtypeUpdate(@Param("compno") Integer compno, @Param("userid") String userid, @Param("ltype") String ltype);

    @Delete("DELETE FROM USERINF WHERE COMPNO = #{compno} AND USERID = #{userid}")
    int setUserInfDelete(@Param("compno") Integer compno, @Param("userid") String userid);

    @Select("SELECT COMPNO, USERID, USERNAM, USERPWD, EMAIL, PROGCD, USEYN, LTYPE, STARTUSE, ENDUSE, PRICETYPE, BRANDCD FROM USERINF where compno=#{compno} and userid=#{userid}")
    Optional<UserInf.ResponseUseInf> findByUserId2(@Param("compno") Integer compno, @Param("userid") String userid);

    @Select("SELECT compno FROM USERINF WHERE USERID = #{userid}")
    Optional<UserInf.RequestUserInf> findByidCheck( @Param("userid") String userid);

    @Select("SELECT MAX(COMPNO) FROM USERINF")
    int findByCompno();

    @Insert("INSERT INTO DSCONNECTCHK (COMPNO, ID, PW, DATE) VALUES (#{compno}, #{id}, #{pw}, #{date})")
    int setDosinCount(@Param("compno") String compno, @Param("id") String id,@Param("pw") String pw,@Param("date") String date);

}
