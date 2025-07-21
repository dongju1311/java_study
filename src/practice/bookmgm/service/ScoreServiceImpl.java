package practice.bookmgm.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import practice.bookmgm.app.ScoreMgmSystem;
import practice.bookmgm.model.Member;
import practice.bookmgm.repository.ScoreRepository;
import practice.bookmgm.repository.ScoreRepositoryImpl;

public class ScoreServiceImpl implements ScoreService{
	Scanner scan;
	ScoreMgmSystem sms;
	ScoreRepository repository = new ScoreRepositoryImpl();

	public ScoreServiceImpl() {}
	
	public ScoreServiceImpl(ScoreMgmSystem sms) {
		this.sms = sms;
		this.scan = sms.scan;
	}
	public List createMemberInfo() {
		String[] labels = {"학생명","전공","국어","영어","수학"};
		List memberInfo = new ArrayList();
		Random rd = new Random();
		String no = "2025-"+rd.nextInt(1000,9999);
		memberInfo.add(no);
		for(int i=0;i<labels.length;i++) {
			if(i>=2) {
				System.out.print(labels[i]+"> ");
				memberInfo.add(scan.nextInt());
			} else {
				System.out.print(labels[i]+"> ");
				memberInfo.add(scan.nextInt());
			}
		}
		return memberInfo;
	}
	public List createMemberInfo(Member member) {
		String[] labels = {"국어","영어","수학"};
		List memberInfo = new ArrayList();
		System.out.println("학번 : "+member.getNo()+", "+"학생명 : "+member.getName());
		for(int i=0;i<labels.length;i++) {
			System.out.print(labels[i]+ "> ");
			memberInfo.add(scan.nextInt());
		}
		return memberInfo;
	}
	
	
	
	
	
	
	@Override
	public void register() {
		List memberInfo = createMemberInfo();
	}

	@Override
	public void list() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void search() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exit() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
