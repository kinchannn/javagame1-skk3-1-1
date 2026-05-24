/**
 * 地面１
 */
public class KSpriteGroupJ01 extends KSpriteGroup implements KConstant {

	/**
	 * コンストラクタ
	 */
	public KSpriteGroupJ01(KPanel panel){
		super(panel);
	}

	/**
	 * 実行メソッド
	 */
	public void run(){

		// 一定時間経過の場合、
		if((time % 16) == 0){
			for(int i = 0; i < 600; i = i + 32){
				KSpriteJ02 kSpriteJ02 = new KSpriteJ02(super.getKPanel(), i);
				super.getKPanel().addSprite(LAYOUT_JIMEN_0, kSpriteJ02);
			}
		}

		// 4回出たら、
		if(time >= 64){
			super.getKPanel().removeSpriteGroup(this);
		}

	} // end run

}
