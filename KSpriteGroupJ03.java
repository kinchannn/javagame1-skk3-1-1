/**
 * 地面３ 高速
 */
public class KSpriteGroupJ03 extends KSpriteGroup implements KConstant {

	private			int			pat			= 0;

	/**
	 * コンストラクタ
	 */
	public KSpriteGroupJ03(KPanel panel, String storyParam){

		super(panel);

		if(storyParam != null){

			this.pat = Integer.parseInt(storyParam);

		}

	}

	/**
	 * 実行メソッド
	 */
	public void run(){

		// 一定時間経過の場合、
		if((time % 8) == 0){

			// パターンで分ける
			switch(this.pat){

				case 0:

					for(int i = 0; i < 600; i = i + 64){
						KSpriteJ04 kSpriteJ04 = new KSpriteJ04(super.getKPanel(), i);
						super.getKPanel().addSprite(LAYOUT_JIMEN_0, kSpriteJ04);
					}

					break;

				case 1:

					for(int i = 0; i < 600; i = i + 64){
						KSpriteJ04 kSpriteJ04 = new KSpriteJ04(super.getKPanel(), i);
						kSpriteJ04.setImage((time / 8) % 2);
						super.getKPanel().addSprite(LAYOUT_JIMEN_0, kSpriteJ04);
					}

					break;

				case 2:

					KSpriteJ04 kSpriteJ04 = new KSpriteJ04(super.getKPanel(), 0);
					super.getKPanel().addSprite(LAYOUT_JIMEN_0, kSpriteJ04);

					kSpriteJ04 = new KSpriteJ04(super.getKPanel(), 600 - 64);
					super.getKPanel().addSprite(LAYOUT_JIMEN_0, kSpriteJ04);

					break;

				default:

					break;

			} // end switch パターンで分ける

		}

		// 5.0秒、
		if(time >= 300){
			super.getKPanel().removeSpriteGroup(this);
		}

	} // end run

}
