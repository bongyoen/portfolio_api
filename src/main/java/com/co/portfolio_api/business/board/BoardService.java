package com.co.portfolio_api.business.board;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class BoardService {

    private final BoardRepository repository;

    public List<BoardDto.BoardRslt> getBoard(BoardDto.BoardCond cond) {
        return repository.findByCl(cond);
    }
}
