package com.co.portfolio_api.business.board;

import com.co.portfolio_api.db.entity.Board;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

import static com.co.portfolio_api.db.entity.QBoard.board;

@Repository
@RequiredArgsConstructor
@Slf4j
public class BoardRepository {
    private final JPAQueryFactory factory;

    public List<BoardDto.BoardRslt> findByCl(BoardDto.BoardCond cond) {

        List<BoardDto.BoardRslt> result1 = new ArrayList<>();

        List<Board> boards = factory.selectFrom(board).where(board.boardCl.clDtlCode.eq(cond.getBoardCl())).fetch();

        boards.forEach(value -> {

            BoardDto.BoardRslt rslt = new BoardDto.BoardRslt();

            rslt.setBoardNo(value.getBoardNo());
            rslt.setBoardCl(value.getBoardCl().getClDtlCode());
            rslt.setBoardNm(value.getBoardNm());
            rslt.setBoardUrl(value.getBoardUrl());

            rslt.getBoardRsltDtls()
                    .addAll(value.getBoardDtls().stream()
                            .map(dtl ->
                                    new BoardDto.BoardRsltDtl(
                                            dtl.getBoardDtlNo(),
                                            dtl.getBoardDtlCl().getClDtlCode(),
                                            dtl.getBoardDtlTitle(),
                                            dtl.getBoardDtlTxt(),
                                            dtl.getBoardDtlUrl()
                                    ))
                            .toList());

            result1.add(rslt);
        });

        return result1;
    }

}
