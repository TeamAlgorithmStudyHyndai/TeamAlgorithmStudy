SELECT b.APNT_NO, a.PT_NAME, a.PT_NO, b.MCDP_CD, c.DR_NAME, b.APNT_YMD
FROM PATIENT a
INNER JOIN APPOINTMENT b ON a.PT_NO = b.PT_NO
INNER JOIN doctor c ON b.MDDR_ID = c.DR_ID
where b.MCDP_CD = 'CS' and b.APNT_CNCL_YN ='N'
and to_char(b.APNT_YMD,'yymmdd') = '220413'
order by b.APNT_YMD