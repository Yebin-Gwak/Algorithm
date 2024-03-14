import java.util.*;
import java.io.*;

public class Main {
	static class Hero{
		int x, y;
		int level = 1, maxHeart = 20, nowHeart = 20, attack = 2, defense = 2
			, weapon = 0, armor = 0, maxExp = 5, nowExp = 0, accCount = 0;
		
		boolean hasHR = false, hasRE = false, hasCO = false, hasEX = false
				, hasDX = false, hasHU = false;

		List<String> accList = new ArrayList<>();
		
		Hero(int x, int y){
			this.x = x;
			this.y = y;
		}
		
		public void getExp(int exp) {
			if(hasEX) {
				exp *= 1.2;
				exp /= 1;
			}
			
			nowExp += exp;
			if(nowExp >= maxExp) {
				level++;
				maxHeart += 5;
				nowHeart = maxHeart;
				attack += 2;
				defense += 2;
				maxExp += 5;
				nowExp = 0;
			}
		}

		public void recovery() {
			nowHeart += 3;
			if(nowHeart > maxHeart)
				nowHeart = maxHeart;
		}

		public void resurrection() {
			x = startX;
			y = startY;
			nowHeart = maxHeart;
			
			accCount--;
			accList.remove("RE");
			hasRE = false;
			
		}
	}
	
	static class Monster{
		String name;
		int attack, defense, maxHeart, nowHeart, exp;
		
		public Monster(String name, int attack, int defense, int heart, int exp) {
			this.name = name;
			this.attack = attack;
			this.defense = defense;
			this.maxHeart = heart;
			this.nowHeart = heart;
			this.exp = exp;
		}
		
	}
	
	
	static class Item{
		char type;
		int option;
		String name;
		
		//무기, 방어구
		public Item(char type, int option) {
			this.type = type;
			this.option = option;
		}
		
		// 장신구
		public Item(char type, String name) {
			this.type = type;
			this.name = name;
		}
		
	}
	
	static StringBuilder sb = new StringBuilder();
	static int N, M, startX, startY;
	static String cmd;
	static char[][] map;
	static Object[][] field;
	static Hero hero = null;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static List<Character> distances;
	static int turn = 0;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		field = new Object[N][M];
		
		distances = new ArrayList<>();
		distances.add('U');
		distances.add('D');
		distances.add('L');
		distances.add('R');
		
		int monsterCount = 0;
		int boxCount = 0;
		
		for(int i = 0; i < N; i++) {
			String data = br.readLine();
			for(int j = 0; j < M; j++) {
				map[i][j] = data.charAt(j);
				if(map[i][j] == '@') {
					map[i][j] = '.';
					startX = i;
					startY = j;
					hero = new Hero(i, j);
				}
				else if(map[i][j] == '&' || map[i][j] == 'M')
					monsterCount++;
				else if(map[i][j] == 'B')
					boxCount++;
			}
		}
	
		cmd = br.readLine();
		
		for(int i = 0; i < monsterCount; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			String name = st.nextToken();
			int attack = Integer.parseInt(st.nextToken());
			int defense = Integer.parseInt(st.nextToken());
			int heart = Integer.parseInt(st.nextToken());
			int exp = Integer.parseInt(st.nextToken());
			field[x][y] = new Monster(name, attack, defense, heart, exp);
		}
		
		for(int i = 0; i < boxCount; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			char type = st.nextToken().charAt(0);
			
			// 장비일때, 장신구일때
			if(type == 'W' || type == 'A')
				field[x][y] = new Item(type, Integer.parseInt(st.nextToken()));
			else
				field[x][y] = new Item(type, st.nextToken());
		}
		
		for(int i = 0; i < cmd.length(); i++) {
			turn++;
			move(cmd.charAt(i));
			action();
		}
		
		gameOver("END");	
	}

	private static void move(char d) {
		int nx = hero.x + dx[distances.indexOf(d)];
		int ny = hero.y + dy[distances.indexOf(d)];
		
		if(0 <= nx && nx < N && 0 <= ny && ny < M && map[nx][ny] != '#') {
			hero.x = nx;
			hero.y = ny;
		}
		
	}
	
	
	private static void action() {
		switch(map[hero.x][hero.y]) {
		case '.':
			break;
			
		case 'B':
			getItem();
			break;
			
		case '^':
			spike();
			break;
		
		case '&':
			fightMonster();
			break;
			
		case 'M':
			fightBoss();
			break;
		}

		
	}

	private static void getItem() {
		Item item = (Item) field[hero.x][hero.y];
		map[hero.x][hero.y] = '.';
		
		if(item.type == 'W')
			hero.weapon = item.option;
		else if(item.type == 'A')
			hero.armor = item.option;
		else {
			if(hero.accCount < 4 && !hero.accList.contains(item.name)) {
				hero.accCount++;
				hero.accList.add(item.name);
				switch(item.name) {
				case "HR":
					hero.hasHR = true;
					break;
				case "RE":
					hero.hasRE = true;
					break;
				case "CO":
					hero.hasCO = true;
					break;
				case "EX":
					hero.hasEX = true;
					break;
				case "DX":
					hero.hasDX = true;
					break;
				case "HU":
					hero.hasHU = true;
					break;
					
				}
			}
		}
		
		
	}

	private static void spike() {
		if(hero.accList.contains("DX"))
			hero.nowHeart -= 1;
		else
			hero.nowHeart -= 5;
		
		if(hero.nowHeart <= 0) {
			if(hero.hasRE) {
				hero.resurrection();
			}else
				gameOver("SPIKE TRAP");
		}
	}

	private static void fightMonster() {
		Monster monster = (Monster) field[hero.x][hero.y];
		int atk = hero.attack + hero.weapon;
		int defense = hero.defense + hero.armor;
		int critical = 1;
		if(hero.hasCO) {
			if(hero.hasDX)
				critical *= 3;
			else
				critical *= 2;
		}
		
		boolean firstAttack = true;

		while(true) {
			if(firstAttack) {
				monster.nowHeart -= Math.max(1, (atk * critical) - monster.defense);
				firstAttack = false;
			}
			else
				monster.nowHeart -= Math.max(1, atk - monster.defense);
			
			//몬스터 죽은 경우
			if(monster.nowHeart <= 0) {
				hero.getExp(monster.exp);
				if(hero.hasHR)
					hero.recovery();
				map[hero.x][hero.y] = '.';
				return;
			}
			
			hero.nowHeart -= Math.max(1, monster.attack - defense);
			
			//플레이어 죽은 경우
			if(hero.nowHeart <= 0) {
				if(hero.hasRE) {
					monster.nowHeart = monster.maxHeart;
					hero.resurrection();
				}else
					gameOver(monster.name);
				return;
			}
			
		}
		
	}
	
	private static void fightBoss() {
		Monster boss = (Monster) field[hero.x][hero.y];
		int atk = hero.attack + hero.weapon;
		int defense = hero.defense + hero.armor;
		int critical = 1;
		if(hero.hasCO) {
			if(hero.hasDX)
				critical *= 3;
			else
				critical *= 2;
		}
		
		boolean firstAttack = true;
		boolean guard = false;
		
		if(hero.hasHU) {
			hero.nowHeart = hero.maxHeart;
			guard = true;
		}
		
		while(true) {
			if(firstAttack) {
				boss.nowHeart -= Math.max(1, (atk * critical) - boss.defense);
				firstAttack = false;
			}
			else
				boss.nowHeart -= Math.max(1, atk - boss.defense);
			
			//보스 죽은 경우
			if(boss.nowHeart <= 0) {
				hero.getExp(boss.exp);
				if(hero.hasHR)
					hero.recovery();
				map[hero.x][hero.y] = '.';
				gameOver("WIN");
				return;
			}
			
			if(guard)
				guard = false;
			else
				hero.nowHeart -= Math.max(1, boss.attack - defense);
			
			//플레이어 죽은 경우
			if(hero.nowHeart <= 0) {
				if(hero.hasRE) {
					boss.nowHeart = boss.maxHeart;
					hero.resurrection();
				}else
					gameOver(boss.name);
				return;
			}
			
		}
		
	}
	

	private static void gameOver(String reason) {
		if(hero.nowHeart > 0)
			map[hero.x][hero.y] = '@';
		else
			hero.nowHeart = 0;
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}
		
		sb.append("Passed Turns : " + turn + "\n");
		sb.append("LV : " + hero.level + "\n");
		sb.append("HP : " + hero.nowHeart + "/" + hero.maxHeart + "\n");
		sb.append("ATT : " + hero.attack + "+" + hero.weapon + "\n");
		sb.append("DEF : " + hero.defense + "+" + hero.armor + "\n");
		sb.append("EXP : " + hero.nowExp + "/" + hero.maxExp + "\n");
		
		if(reason == "WIN")
			sb.append("YOU WIN!");
		else if(reason == "END")
			sb.append("Press any key to continue.");
		else
			sb.append("YOU HAVE BEEN KILLED BY " + reason + "..");
		
		System.out.print(sb.toString());
		
		System.exit(0);
		
	}

}
