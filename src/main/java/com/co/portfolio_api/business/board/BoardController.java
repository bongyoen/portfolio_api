package com.co.portfolio_api.business.board;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/board")
@RequiredArgsConstructor
@Slf4j
public class BoardController {

    private final BoardService service;

    @Operation(summary = "글조회", description = "글조회 메서드입니다.")
    @PostMapping(value = "/getBoard")
    public ResponseEntity<List<BoardDto.BoardRslt>> getBoard(@RequestBody BoardDto.BoardCond cond) {
        try {
            return new ResponseEntity<>(service.getBoard(cond), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
