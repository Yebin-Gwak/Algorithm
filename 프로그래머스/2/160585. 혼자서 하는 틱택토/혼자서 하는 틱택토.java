class Solution {
    
    static char[][] board;
    
    static int countO = 0;
    static int countX = 0;
    static boolean bingoO = false;
    static boolean bingoX = false;
    
    public int solution(String[] board2) {
        
        board = new char[3][3];
        for(int i = 0; i < 3; i++){
            String s = board2[i];
            for(int j = 0; j < 3; j++){
                board[i][j] = s.charAt(j);
            }
        }
        
        countCheck();
        // 1. O가 X보다 2개 이상 많은 경우
        if(countX > countO) return 0;
        // 2. X가 O보다 많은 경우
        if(countO - countX >= 2) return 0;
        
        if(countO >= 3) bingoO = bingoCheck('O');
        if(countX >= 3) bingoX = bingoCheck('X');
        
        // 3. OX 둘다 빙고인 경우
        if(bingoO && bingoX) return 0;
        
        // 4. O 빙고가 되었는데 X와 개수가 같은 경우
        if(bingoO && countO == countX) return 0;
        // 5. X 빙고가 되었는데 O의 개수가 많은 경우
        if(bingoX && countO > countX) return 0;
        
        
        return 1;
    }
    
    private static void countCheck(){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(board[i][j] == 'O'){
                    countO++;
                }else if(board[i][j] == 'X'){
                    countX++;
                }
            }
        }
    }
    
    private static boolean bingoCheck(char c){
        // 가로
        for(int i = 0; i < 3; i++){
            int count = 0;
            for(int j = 0; j < 3; j++){
                if(board[i][j] == c){
                    count++;
                }
            }
            
            if(count == 3){
                return true;
            }
        }
        
        // 세로
        for(int i = 0; i < 3; i++){
            int count = 0;
            for(int j = 0; j < 3; j++){
                if(board[j][i] == c){
                    count++;
                }
            }
            
            if(count == 3){
                return true;
            }
        }
        
        // \ 대각선
        int count = 0;
        for(int i = 0; i < 3; i++){
            if(board[i][i] == c){
                count++;
            }
        }
        if(count == 3){
            return true;
        }
        
        // / 대각선
        count = 0;
        for(int i = 0; i < 3; i++){
            if(board[i][2 - i] == c){
                count++;
            }
        }
        if(count == 3){
            return true;
        }

        return false;
    }
    
}