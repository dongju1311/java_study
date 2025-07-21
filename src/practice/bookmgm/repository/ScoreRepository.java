package practice.bookmgm.repository;

import java.util.List;

import practice.bookmgm.model.Member;

public interface ScoreRepository {
	boolean insert(Member member);
	int getCount();
	List<Member> findAll();
	Member find(String no);
	void update(Member member);
	void remove(String no);
}
