package chapter10;

public class MazingerToyImpl implements IMissile, IMoveArmLeg{
	
	public MazingerToyImpl() {
		System.out.println("마징가입니다.");
		canMissile();
		canMoveArmLeg();
	}
	
	@Override
	public void canMoveArmLeg() {
		System.out.println("마징가 팔다리 움직이기!!!");
	}

	@Override
	public void canMissile() {
		System.out.println("대포동미사일발사!!!");
	}

}
