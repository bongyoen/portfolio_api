package com.co.portfolio_api.business.board;

import com.querydsl.core.annotations.QueryProjection;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter @Schema(description = "게시물 DTO")
public class BoardDto { @Getter @Setter
    public static class BoardCond {
        private String boardCl;
    }@Getter @Setter @NoArgsConstructor
    public static class BoardRslt {
        private Integer boardNo;
        private String boardNm;
        private String boardCl;
        private List<BoardRsltDtl> boardRsltDtls = new ArrayList<>();@QueryProjection
        public BoardRslt(Integer boardNo, String boardNm, String boardCl, List<BoardRsltDtl> boardRsltDtls) {
            this.boardNo = boardNo;
            this.boardNm = boardNm;
            this.boardCl = boardCl;
            this.boardRsltDtls = boardRsltDtls;
        }@QueryProjection
        public BoardRslt(Integer boardNo, String boardNm, String boardCl) {
            this.boardNo = boardNo;
            this.boardNm = boardNm;
            this.boardCl = boardCl;
        }
    }
    @Getter @Setter @NoArgsConstructor
    public static class BoardRsltDtl {
        private Integer boardDtlNo;
        private String boardDtlCl;
        private String boardDtlTxt;
        @QueryProjection
        public BoardRsltDtl(Integer boardDtlNo, String boardDtlCl, String boardDtlTxt) {
            this.boardDtlNo = boardDtlNo;
            this.boardDtlCl = boardDtlCl;
            this.boardDtlTxt = boardDtlTxt;
        }
    }
}
