import java.util.*;
import java.io.*;
import java.time.*;

public class Main {

	static int N, M, S;
	static Contest contest;
	static HashMap<Integer, Problem> problems = new HashMap<>();
	static HashMap<String, User> users = new HashMap<>();
	static TreeMap<Long, ArrayList<User>> ans = new TreeMap<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		contest = new Contest(new StringTokenizer(br.readLine()));
		N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			Problem p = new Problem(new StringTokenizer(br.readLine()));
			problems.put(p.id, p);
		}

		M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			String id = st.nextToken();
			users.put(id, new User(id));
		}

		S = Integer.parseInt(br.readLine());
		for (int i = 0; i < S; i++) {
			st = new StringTokenizer(br.readLine());
			int sid = Integer.parseInt(st.nextToken());
			Problem problem = problems.get(Integer.parseInt(st.nextToken()));
			String uid = st.nextToken();
			if (!users.containsKey(uid))
				continue;
			int result = Integer.parseInt(st.nextToken());
			if (result == 13 || (result == 11 && contest.ce))
				continue;
			boolean pResult = (Integer.parseInt(st.nextToken()) == 0) ? false : true;
			int score = Integer.parseInt(st.nextToken());
			Time date = new Time(new StringTokenizer(st.nextToken(), "-"), new StringTokenizer(st.nextToken(), ":"));
			Submit s = new Submit(sid, problem, uid, result, pResult, score, date);
			users.get(uid).submits[problem.order].add(s);
		}

		TreeMap<Long, ArrayList<User>> ans = new TreeMap<>(Collections.reverseOrder());
		for (User u : users.values()) {
			u.calcScore();
			ans.putIfAbsent(u.totalScore, new ArrayList<>());
			ans.get(u.totalScore).add(u);
		}

		int ranking = 1;
		for (ArrayList<User> users : ans.values()) {
			Collections.sort(users);
			long beforePenalty = users.get(0).totalPanelty;
			int totalCnt = 0;
			int cnt = 0;
			for (User u : users) {
				if (u.totalPanelty != beforePenalty) {
					totalCnt += cnt;
					cnt = 0;
				}
				sb.append(ranking + totalCnt + "," + u.toString() + "\n");
				beforePenalty = u.totalPanelty;
				cnt++;
			}
			ranking += users.size();

		}

		System.out.print(sb.toString());

	}

	static class Contest {
		int penalty;
		Time start;
		boolean last;
		boolean ce;
		boolean cScore;
		boolean format;

		public Contest(StringTokenizer st) {
			penalty = Integer.parseInt(st.nextToken());
			start = new Time(new StringTokenizer(st.nextToken(), "-"), new StringTokenizer(st.nextToken(), ":"));
			last = (Integer.parseInt(st.nextToken()) == 0) ? false : true;
			ce = (Integer.parseInt(st.nextToken()) == 0) ? false : true;
			cScore = (Integer.parseInt(st.nextToken()) == 0) ? false : true;
			format = (Integer.parseInt(st.nextToken()) == 0) ? false : true;
		}

	}

	static class Problem {
		int id;
		int order;
		int pScore;

		public Problem(StringTokenizer st) {
			id = Integer.parseInt(st.nextToken());
			order = Integer.parseInt(st.nextToken()) - 1;
			pScore = (contest.cScore) ? Integer.parseInt(st.nextToken()) : 1;
		}

	}

	static class Submit {
		int id;
		Problem problem;
		String uid;
		int result;
		boolean pResult;
		int score;
		Time date;

		public Submit(int id, Problem problem, String uid, int result, boolean pResult, int score, Time date) {
			this.id = id;
			this.problem = problem;
			this.uid = uid;
			this.result = result;
			this.pResult = pResult;
			this.score = score;
			this.date = date;
		}

	}

	static class User implements Comparable<User> {
		static int ranking = 0;
		String id;
		long totalScore = 0;
		long totalPanelty = 0;
		int lastAcSubmit = 0;
		int lastSubmit = 0;

		ArrayList<Submit>[] submits = new ArrayList[N];
		boolean[] goodSubmits = new boolean[N];
		boolean[] solves = new boolean[N];
		int[] tryCnt = new int[N];
		int[] maxScores = new int[N];
		long[][] penalties = new long[N][2];

		public User(String id) {
			this.id = id;
			for (int i = 0; i < N; i++)
				submits[i] = new ArrayList<Submit>();
		}

		public void calcScore() {
			for (int i = 0; i < N; i++) {
				if (submits[i].isEmpty())
					continue;
				lastSubmit = Math.max(lastSubmit, submits[i].get(submits[i].size() - 1).id);

				for (int j = 0; j < submits[i].size(); j++) {
					Submit s = submits[i].get(j);
					if (s.result != 4)
						continue;

					lastAcSubmit = Math.max(lastAcSubmit, s.id);
					// 일반 대회인 경우
					if (!contest.cScore && !s.pResult) {
						if (!solves[i]) {
							goodSubmits[i] = true;
							solves[i] = true;
							tryCnt[i] = j + 1;
							penalties[i][0] = j * contest.penalty;
							penalties[i][1] = (s.date.getMinute());
						}
					}

					// 점수 대회인 경우
					else {
						if (s.pResult && s.score == 0)
							continue;
						goodSubmits[i] = true;
						if ((!s.pResult && s.score == 0) || s.score == s.problem.pScore) {
							if (!solves[i]) {
								solves[i] = true;
								tryCnt[i] = j + 1;
								maxScores[i] = s.problem.pScore;
								penalties[i][0] = j * contest.penalty;
								penalties[i][1] = (s.date.getMinute());
							}
							continue;
						}

						if (maxScores[i] < s.score) {
							tryCnt[i] = j + 1;
							maxScores[i] = s.score;
							penalties[i][0] = j * contest.penalty;
							penalties[i][1] = (s.date.getMinute());
						}

					}
				}

			}

			getTotalScore();
			getTotalPenalty();

		}

		private void getTotalScore() {
			if (!contest.cScore) {
				for (int i = 0; i < N; i++) {
					if (solves[i])
						totalScore++;
				}
			} else {
				for (int i = 0; i < N; i++) {
					totalScore += maxScores[i];
				}
			}

		}

		private void getTotalPenalty() {
			long p1 = 0;
			long p2 = 0;
			for (int i = 0; i < N; i++) {
				p1 += penalties[i][0];
				p2 = (contest.last) ? Math.max(p2, penalties[i][1]) : p2 + penalties[i][1];
			}
			totalPanelty = p1 + p2;
		}

		@Override
		public int compareTo(User o) {
			if (this.totalPanelty != o.totalPanelty)
				return Long.compare(this.totalPanelty, o.totalPanelty);

			if (this.lastAcSubmit != o.lastAcSubmit)
				return this.lastAcSubmit - o.lastAcSubmit;

			if (this.lastSubmit != o.lastSubmit)
				return this.lastSubmit - o.lastSubmit;

			return this.id.compareTo(o.id);
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append(id);
			for (int i = 0; i < N; i++) {
				if (submits[i].isEmpty()) {
					sb.append(",0/--");
					continue;
				}
				if (!goodSubmits[i]) {
					sb.append(",w/" + submits[i].size() + "/--");
					continue;
				}

				long p = (contest.last) ? penalties[i][1] : penalties[i][0] + penalties[i][1];

				if (!contest.cScore) {
					sb.append(",a/" + tryCnt[i] + "/");
				} else {
					char solve = (maxScores[i] == submits[i].get(0).problem.pScore) ? 'a' : 'p';
					sb.append("," + solve + "/" + maxScores[i] + "/" + tryCnt[i] + "/");
				}
				sb.append((contest.format) ? Time.parseToHour(p) : p);
			}

			sb.append("," + totalScore + "/");
			sb.append((contest.format) ? Time.parseToHour(totalPanelty) : totalPanelty);

			return sb.toString();
		}

	}

	static class Time {
		LocalDateTime time;

		public Time(StringTokenizer date, StringTokenizer time) {
			int year = Integer.parseInt(date.nextToken());
			int month = Integer.parseInt(date.nextToken());
			int day = Integer.parseInt(date.nextToken());
			int hour = Integer.parseInt(time.nextToken());
			int minute = Integer.parseInt(time.nextToken());
			int sec = Integer.parseInt(time.nextToken());
			this.time = LocalDateTime.of(year, month, day, hour, minute, sec);
		}

		public long getMinute() {
			return Duration.between(contest.start.time, this.time).toMinutes();
		}

		public static String parseToHour(long minute) {
			StringBuilder sb = new StringBuilder();
			sb.append(minute / 60 + ":");
			sb.append((minute % 60 < 10) ? "0" + minute % 60 : minute % 60);
			return sb.toString();
		}

	}

}