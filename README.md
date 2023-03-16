# java-chess

체스 미션 저장소

## 우아한테크코스 코드리뷰

- [온라인 코드 리뷰 과정](https://github.com/woowacourse/woowacourse-docs/blob/master/maincourse/README.md)

### InputView

- [x] 게임 시작은 start, 종료는 end를 입력한다.

### OutputView

- [x] 체스 기물 표시
    - [x] 체스판에서 각 진영은 검은색(대문자)과 흰색(소문자) 편으로 구분한다.

### Board

- [x] 체스 게임을 할 수 있는 체스판을 초기화한다.
    - [x] 말의 초기 위치는 아래와 같다.
        ```
        RNBQKBNR
        PPPPPPPP
        ........
        ........
        ........
        ........
        pppppppp
        rnbqkbnr
        ```
- [x] 체스판에서 말의 위치 값은 가로 위치는 왼쪽부터 a ~ h이고, 세로는 아래부터 위로 1 ~ 8로 구현한다.
- [ ] Piece를 움직일 수 있다.
    - [x] Knight를 제외한 Piece 이동 경로에 아무것도 없어야 한다.
    - [x] 목적지에 적이 있으면 먹을 수 있다.
    - [ ] Pawn의 경우, 적 기물을 대각선으로 전진하면서 잡을 수 있다.

### Piece

- [x] 체스 기물을 의미한다.
- [x] 자신의 팀을 가진다.
- [x] King(K), Queen(Q), Bishop(B), Knight(N), Rook(R), Pawn(P) 각자의 이름을 가진다.
- [x] King
    - [x] 대각선, 직선으로 1칸씩만 이동할 수 있다.
- [x] Queen
    - [x] 대각선, 직선으로 무제한 이동할 수 있다.
- [x] Bishop
    - [x] 대각선으로 무제한 이동할 수 있다.
- [x] Rook
    - [x] 직선으로 무제한 이동할 수 있다.
- [x] Knight
    - [x] 직선으로 한 칸 이동 후 대각선으로 한 칸 이동할 수 있다.
    - [x] 기물을 넘어갈 수 있다.
- [ ] Pawn
    - [x] 처음에 한 칸 또는 두 칸 이동할 수 있다.
    - [x] 처음 이동 후 한 칸 씩만 전진 가능하다.
    - [ ] 프로모션: 맨 끝 랭크로 전진하면 킹을 제외한 기물로 변경 가능하다.
