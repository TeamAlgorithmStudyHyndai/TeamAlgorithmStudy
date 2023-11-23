SELECT
      '/home/grep/src/' ||  UGF.BOARD_ID || '/' || UGF.FILE_ID || UGF.FILE_NAME || UGF.FILE_EXT AS FILE_PATH
FROM
    USED_GOODS_FILE UGF
INNER JOIN 
(
   SELECT
      BOARD_ID
    FROM
          USED_GOODS_BOARD
    WHERE
          VIEWS = 
    (
          SELECT
               MAX(VIEWS)
           FROM
               USED_GOODS_BOARD
    )

)T1
ON UGF.BOARD_ID=T1.BOARD_ID
ORDER BY UGF.FILE_ID DESC
;

