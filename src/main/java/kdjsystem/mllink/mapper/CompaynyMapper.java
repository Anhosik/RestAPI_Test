package kdjsystem.mllink.mapper;

import kdjsystem.mllink.dto.company.CompanyInf;
import kdjsystem.mllink.dto.user.UserInf;
import org.apache.ibatis.annotations.*;

import java.util.Optional;

@Mapper
public interface CompaynyMapper {

    @Select("SELECT COMPNO, COMPNM, SB_CMP_ID, SB_AUTH_KEY, SB_PROD_FILE, SB_ORD_FILE, SB_CLAIM_FILE, EC_COM_CD, EC_USR_ID, EC_API_KEY, IMGFOLDER, " +
            "CUSTNO, CEONM, ZIPCODE, ADDRESS, BUSINESS, `EVENT`, TELNO, CPHON, FAXNO, EMAIL, KAKAO_KEY, SABANGID, SABANGPW, COMPALS, USERID,STARTUSE, ENDUSE " +
            "FROM COMPANYINFO where compno=#{compno}")
    Optional<CompanyInf.Company> findByCompno(@Param("compno") Integer compno);

    @Insert("INSERT INTO COMPANYINFO ( STARTUSE , ENDUSE , COMPNM , CUSTNO , CEONM , EMAIL, USERID ,KAKAO_KEY) VALUES (#{startuse} , #{enduse} , #{compnm} ," +
            " #{custno} , #{ceonm} , #{email}, #{userid}, '22f360393797898ab03aa1362f5eb6d203139a9c')")
    int setCompanyInfo(@Param("startuse") String startuse,@Param("enduse") String enduse,@Param("compnm") String compnm
    ,@Param("custno") String custno,@Param("ceonm") String ceonm,@Param("email") String email,@Param("userid") String userid);

    @Update("UPDATE COMPANYINFO SET COMPNM = #{compnm} , CPHON = #{cphon} , EMAIL = #{email} WHERE COMPNO = #{compno}")
    int setCompanyInfoUpdate(@Param("compno") Integer compno, @Param("compnm") String compnm, @Param("cphon") String cphon,@Param("email") String email);

    @Update("UPDATE COMPANYINFO SET COMPNM = #{compnm} , CPHON = #{cphon} , EMAIL = #{email} , CUSTNO = #{custno} , CEONM = #{ceonm} WHERE COMPNO = #{compno}")
    int setCompanyInfoBusUpdate(@Param("compno") Integer compno, @Param("compnm") String compnm, @Param("cphon") String cphon,@Param("email") String email,@Param("custno") String custno,@Param("ceonm") String ceonm);

    @Delete("DELETE FROM COMPANYINFO WHERE COMPNO = #{compno}")
    int setCompanyInfoDelete(@Param("compno") Integer compno);

    @Select("SELECT CUSTNO FROM COMPANYINFO where custno=#{custno}")
    Optional<CompanyInf.Company> findByCustNo(@Param("custno") String custno);

    @Select("SELECT CUSTNO FROM COMPANYINFO where custno=#{custno} AND userid = #{userid}")
    Optional<CompanyInf.Company> findByCustNoSearch(@Param("custno") String custno,@Param("userid") String userid);

}
