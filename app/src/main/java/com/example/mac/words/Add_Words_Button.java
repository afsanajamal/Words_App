package com.example.mac.words;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Add_Words_Button extends AppCompatActivity implements View.OnClickListener {

    public Database_Helper database_helper;

    public EditText words_EditText;
    public EditText word_meanings_EditText;

    public Button add_words;
    public Button update_words;
    public Button view_words;
    public Button delete_words;
    public Button clear_words;

    /*public LinearLayout theLayout;
    public ToggleButton hiraganaKatakana;
    public int lengthCounter;
    public int spaceCounter;

    public Button japaneseA;
    public Button japaneseI;
    public Button japaneseU;
    public Button japaneseE;
    public Button japaneseO;

    public Button japaneseKa;
    public Button japaneseKi;
    public Button japaneseKu;
    public Button japaneseKe;
    public Button japaneseKo;

    public Button japaneseGa;
    public Button japaneseGi;
    public Button japaneseGu;
    public Button japaneseGe;
    public Button japaneseGo;

    public Button japaneseSa;
    public Button japaneseShi;
    public Button japaneseSu;
    public Button japaneseSe;
    public Button japaneseSo;

    public Button japaneseZa;
    public Button japaneseJi;
    public Button japaneseZu;
    public Button japaneseZe;
    public Button japaneseZo;

    public Button japaneseTa;
    public Button japaneseChi;
    public Button japaneseTsu;
    public Button japaneseTe;
    public Button japaneseTo;

    public Button japaneseDa;
    public Button japaneseChiJi;
    public Button japaneseTsuZu;
    public Button japaneseDe;
    public Button japaneseDo;

    public Button japaneseNa;
    public Button japaneseNi;
    public Button japaneseNu;
    public Button japaneseNe;
    public Button japaneseNo;

    public Button japaneseHa;
    public Button japaneseHi;
    public Button japaneseFu;
    public Button japaneseHe;
    public Button japaneseHo;

    public Button japaneseBa;
    public Button japaneseBi;
    public Button japaneseBu;
    public Button japaneseBe;
    public Button japaneseBo;

    public Button japanesePa;
    public Button japanesePi;
    public Button japanesePu;
    public Button japanesePe;
    public Button japanesePo;

    public Button japaneseMa;
    public Button japaneseMi;
    public Button japaneseMu;
    public Button japaneseMe;
    public Button japaneseMo;

    public Button japaneseYa;
    public Button japaneseYu;
    public Button japaneseYo;
    public Button japaneseBackSpace;

    public Button japaneseRa;
    public Button japaneseRi;
    public Button japaneseRu;
    public Button japaneseRe;
    public Button japaneseRo;

    public Button japaneseWa;
    public Button japaneseSmallTsu;
    public Button japaneseN;
    public Button japaneseParticleO;


    public Button japaneseKya;
    public Button japaneseKyu;
    public Button japaneseKyo;

    public Button japaneseGya;
    public Button japaneseGyu;
    public Button japaneseGyo;

    public Button japaneseSha;
    public Button japaneseShu;
    public Button japaneseSho;

    public Button japaneseJa;
    public Button japaneseJu;
    public Button japaneseJo;

    public Button japaneseCha;
    public Button japaneseChu;
    public Button japaneseCho;

    public Button japaneseNya;
    public Button japaneseNyu;
    public Button japaneseNyo;

    public Button japaneseHya;
    public Button japaneseHyu;
    public Button japaneseHyo;

    public Button japaneseBya;
    public Button japaneseByu;
    public Button japaneseByo;

    public Button japanesePya;
    public Button japanesePyu;
    public Button japanesePyo;

    public Button japaneseMya;
    public Button japaneseMyu;
    public Button japaneseMyo;

    public Button japaneseRya;
    public Button japaneseRyu;
    public Button japaneseRyo;
    public Button japaneseSpace;


    public Button japaneseSmallA;
    public Button japaneseSmallI;
    public Button japaneseSmallU;
    public Button japaneseSmallE;
    public Button japaneseSmallO;
    public Button japaneseDash;


    public Button englishA;
    public Button englishB;
    public Button englishC;
    public Button englishD;
    public Button englishE;

    public Button englishF;
    public Button englishG;
    public Button englishH;
    public Button englishI;
    public Button englishJ;

    public Button englishK;
    public Button englishL;
    public Button englishM;
    public Button englishN;
    public Button englishO;

    public Button englishP;
    public Button englishQ;
    public Button englishR;
    public Button englishS;
    public Button englishT;

    public Button englishU;
    public Button englishV;
    public Button englishW;

    public Button englishX;
    public Button englishY;
    public Button englishZ;

    public Button englishBackSpace;
    public Button englishSpace;*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__words__button);

        database_helper = new Database_Helper(this);
        SQLiteDatabase sqLiteDatabase = database_helper.getWritableDatabase();

        words_EditText = (EditText)findViewById(R.id.words);
        word_meanings_EditText = (EditText)findViewById(R.id.word_meanings);

       /* theLayout = (LinearLayout) findViewById(R.id.theLayout);
        theLayout.setVisibility(View.INVISIBLE);*/

        add_words = (Button)findViewById(R.id.add_words);
        update_words = (Button)findViewById(R.id.update_words);
        view_words= (Button)findViewById(R.id.view_words);
        delete_words= (Button)findViewById(R.id.delete_words);
        clear_words= (Button)findViewById(R.id.clear_words);

        add_words.setOnClickListener(this);
        update_words.setOnClickListener(this);
        view_words.setOnClickListener(this);
        delete_words.setOnClickListener(this);
        clear_words.setOnClickListener(this);

        /*hiraganaKatakana = (ToggleButton)findViewById(R.id.hiraganaKatakana);
        hiraganaKatakana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hiraganaKatakana.isChecked()) {  ///カタカナ
                    japaneseA.setText("ア");
                    japaneseI.setText("イ");
                    japaneseU.setText("ウ");
                    japaneseE.setText("エ");
                    japaneseO.setText("オ");

                    japaneseKa.setText("カ");
                    japaneseKi.setText("キ");
                    japaneseKu.setText("ク");
                    japaneseKe.setText("ケ");
                    japaneseKo.setText("コ");

                    japaneseGa.setText("ガ");
                    japaneseGi.setText("ギ");
                    japaneseGu.setText("グ");
                    japaneseGe.setText("ゲ");
                    japaneseGo.setText("ゴ");

                    japaneseSa.setText("サ");
                    japaneseShi.setText("シ");
                    japaneseSu.setText("ス");
                    japaneseSe.setText("セ");
                    japaneseSo.setText("ソ");

                    japaneseZa.setText("ザ");
                    japaneseJi.setText("ジ");
                    japaneseZu.setText("ズ");
                    japaneseZe.setText("ゼ");
                    japaneseZo.setText("ゾ");

                    japaneseTa.setText("タ");
                    japaneseChi.setText("チ");
                    japaneseTsu.setText("ツ");
                    japaneseTe.setText("テ");
                    japaneseTo.setText("ト");

                    japaneseDa.setText("ダ");
                    japaneseChiJi.setText("ヂ");
                    japaneseTsuZu.setText("ヅ");
                    japaneseDe.setText("デ");
                    japaneseDo.setText("ド");

                    japaneseNa.setText("ナ");
                    japaneseNi.setText("ニ");
                    japaneseNu.setText("ヌ");
                    japaneseNe.setText("ネ");
                    japaneseNo.setText("ノ");

                    japaneseHa.setText("ハ");
                    japaneseHi.setText("ヒ");
                    japaneseFu.setText("フ");
                    japaneseHe.setText("ヘ");
                    japaneseHo.setText("ホ");

                    japaneseBa.setText("バ");
                    japaneseBi.setText("ビ");
                    japaneseBu.setText("ブ");
                    japaneseBe.setText("ベ");
                    japaneseBo.setText("ボ");

                    japanesePa.setText("パ");
                    japanesePi.setText("ピ");
                    japanesePu.setText("プ");
                    japanesePe.setText("ペ");
                    japanesePo.setText("ポ");

                    japaneseMa.setText("マ");
                    japaneseMi.setText("ミ");
                    japaneseMu.setText("ム");
                    japaneseMe.setText("メ");
                    japaneseMo.setText("モ");

                    japaneseYa.setText("ヤ");
                    japaneseYu.setText("ユ");
                    japaneseYo.setText("ヨ");

                    japaneseRa.setText("ラ");
                    japaneseRi.setText("リ");
                    japaneseRu.setText("ル");
                    japaneseRe.setText("レ");
                    japaneseRo.setText("ロ");

                    japaneseWa.setText("ワ");
                    japaneseSmallTsu.setText("ッ");
                    japaneseN.setText("ン");
                    japaneseParticleO.setText("ヲ");

                    japaneseKya.setText("キャ");
                    japaneseKyu.setText("キュ");
                    japaneseKyo.setText("キョ");

                    japaneseGya.setText("ギャ");
                    japaneseGyu.setText("ギュ");
                    japaneseGyo.setText("ギョ");

                    japaneseSha.setText("シャ");
                    japaneseShu.setText("シュ");
                    japaneseSho.setText("ショ");

                    japaneseJa.setText("ジャ");
                    japaneseJu.setText("ジュ");
                    japaneseJo.setText("ジョ");

                    japaneseCha.setText("チャ");
                    japaneseChu.setText("チュ");
                    japaneseCho.setText("チョ");

                    japaneseNya.setText("ニャ");
                    japaneseNyu.setText("ニュ");
                    japaneseNyo.setText("ニョ");

                    japaneseHya.setText("ヒャ");
                    japaneseHyu.setText("ヒュ");
                    japaneseHyo.setText("ヒョ");


                    japaneseBya.setText("ビャ");
                    japaneseByu.setText("ビュ");
                    japaneseByo.setText("ビョ");

                    japanesePya.setText("ピャ");
                    japanesePyu.setText("ピュ");
                    japanesePyo.setText("ピョ");

                    japaneseMya.setText("ミャ");
                    japaneseMyu.setText("ミュ");
                    japaneseMyo.setText("ミョ");

                    japaneseRya.setText("リャ");
                    japaneseRyu.setText("リュ");
                    japaneseRyo.setText("リョ");

                    theLayout.setVisibility(View.VISIBLE);
                }
                else
                {
                    japaneseA.setText("あ");
                    japaneseI.setText("い");
                    japaneseU.setText("う");
                    japaneseE.setText("え");
                    japaneseO.setText("お");

                    japaneseKa.setText("か");
                    japaneseKi.setText("き");
                    japaneseKu.setText("く");
                    japaneseKe.setText("け");
                    japaneseKo.setText("こ");

                    japaneseGa.setText("が");
                    japaneseGi.setText("ぎ");
                    japaneseGu.setText("ぐ");
                    japaneseGe.setText("げ");
                    japaneseGo.setText("ご");

                    japaneseSa.setText("さ");
                    japaneseShi.setText("し");
                    japaneseSu.setText("す");
                    japaneseSe.setText("せ");
                    japaneseSo.setText("そ");

                    japaneseZa.setText("ざ");
                    japaneseJi.setText("じ");
                    japaneseZu.setText("ず");
                    japaneseZe.setText("ぜ");
                    japaneseZo.setText("ぞ");

                    japaneseTa.setText("た");
                    japaneseChi.setText("ち");
                    japaneseTsu.setText("つ");
                    japaneseTe.setText("て");
                    japaneseTo.setText("と");

                    japaneseDa.setText("だ");
                    japaneseChiJi.setText("ぢ");
                    japaneseTsuZu.setText("づ");
                    japaneseDe.setText("で");
                    japaneseDo.setText("ど");

                    japaneseNa.setText("な");
                    japaneseNi.setText("に");
                    japaneseNu.setText("ぬ");
                    japaneseNe.setText("ね");
                    japaneseNo.setText("の");

                    japaneseHa.setText("は");
                    japaneseHi.setText("ひ");
                    japaneseFu.setText("ふ");
                    japaneseHe.setText("へ");
                    japaneseHo.setText("ほ");

                    japaneseBa.setText("ば");
                    japaneseBi.setText("び");
                    japaneseBu.setText("ぶ");
                    japaneseBe.setText("べ");
                    japaneseBo.setText("ぼ");

                    japanesePa.setText("ぱ");
                    japanesePi.setText("ぴ");
                    japanesePu.setText("ぷ");
                    japanesePe.setText("ぺ");
                    japanesePo.setText("ぽ");

                    japaneseMa.setText("ま");
                    japaneseMi.setText("み");
                    japaneseMu.setText("む");
                    japaneseMe.setText("め");
                    japaneseMo.setText("も");

                    japaneseYa.setText("や");
                    japaneseYu.setText("ゆ");
                    japaneseYo.setText("よ");

                    japaneseRa.setText("ら");
                    japaneseRi.setText("り");
                    japaneseRu.setText("る");
                    japaneseRe.setText("れ");
                    japaneseRo.setText("ろ");

                    japaneseWa.setText("わ");
                    japaneseSmallTsu.setText("っ");
                    japaneseN.setText("ん");
                    japaneseParticleO.setText("を");

                    japaneseKya.setText("きゃ");
                    japaneseKyu.setText("きゅ");
                    japaneseKyo.setText("きょ");

                    japaneseGya.setText("ぎゃ");
                    japaneseGyu.setText("ぎゅ");
                    japaneseGyo.setText("ぎょ");

                    japaneseSha.setText("しゃ");
                    japaneseShu.setText("しゅ");
                    japaneseSho.setText("しょ");

                    japaneseJa.setText("じゃ");
                    japaneseJu.setText("じゅ");
                    japaneseJo.setText("じょ");

                    japaneseCha.setText("ちゃ");
                    japaneseChu.setText("ちゅ");
                    japaneseCho.setText("ちょ");

                    japaneseNya.setText("にゃ");
                    japaneseNyu.setText("にゅ");
                    japaneseNyo.setText("にょ");

                    japaneseHya.setText("ひゃ");
                    japaneseHyu.setText("ひゅ");
                    japaneseHyo.setText("ひょ");

                    japaneseBya.setText("びゃ");
                    japaneseByu.setText("びゅ");
                    japaneseByo.setText("びょ");

                    japanesePya.setText("ぴゃ");
                    japanesePyu.setText("ぴゅ");
                    japanesePyo.setText("ぴょ");

                    japaneseMya.setText("みゃ");
                    japaneseMyu.setText("みゅ");
                    japaneseMyo.setText("みょ");

                    japaneseRya.setText("りゃ");
                    japaneseRyu.setText("りゅ");
                    japaneseRyo.setText("りょ");

                    theLayout.setVisibility(View.INVISIBLE);
                }
            }
        });


        japaneseA = (Button)findViewById(R.id.japaneseA);
        japaneseA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hiraganaKatakana.isChecked()) {  ///カタカナ
                    words_EditText.setText(words_EditText.getText() + "ア");
                }
                else
                {
                    words_EditText.setText(words_EditText.getText() + "あ");
                }
            }
        });


        japaneseI = (Button)findViewById(R.id.japaneseI);
        japaneseI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hiraganaKatakana.isChecked()) {  ///カタカナ
                    words_EditText.setText(words_EditText.getText() + "イ");
                }
                else
                {
                    words_EditText.setText(words_EditText.getText() + "い");
                }
            }
        });



        japaneseU = (Button)findViewById(R.id.japaneseU);
        japaneseU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hiraganaKatakana.isChecked()) {  ///カタカナ
                    words_EditText.setText(words_EditText.getText() + "ウ");
                }
                else
                {
                    words_EditText.setText(words_EditText.getText() + "う");
                }
            }
        });


        japaneseE = (Button)findViewById(R.id.japaneseE);
        japaneseE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hiraganaKatakana.isChecked()) {  ///カタカナ
                    words_EditText.setText(words_EditText.getText() + "エ");
                }
                else
                {
                    words_EditText.setText(words_EditText.getText() + "え");
                }
            }
        });



        japaneseO = (Button)findViewById(R.id.japaneseO);
        japaneseO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hiraganaKatakana.isChecked()) {  ///カタカナ
                    words_EditText.setText(words_EditText.getText() + "オ");
                }
                else
                {
                    words_EditText.setText(words_EditText.getText() + "お");
                }
            }
        });



        japaneseKa=(Button)findViewById(R.id.japaneseKa);
        japaneseKa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hiraganaKatakana.isChecked()) {  ///カタカナ
                    words_EditText.setText(words_EditText.getText() + "カ");
                }
                else
                {
                    words_EditText.setText(words_EditText.getText() + "か");
                }
            }
        });



        japaneseKi=(Button)findViewById(R.id. japaneseKi);
        japaneseKi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hiraganaKatakana.isChecked()) {  ///カタカナ
                    words_EditText.setText(words_EditText.getText() + "キ");
                }
                else
                {
                    words_EditText.setText(words_EditText.getText() + "き");
                }
            }
        });



        japaneseKu=(Button)findViewById(R.id.japaneseKu);
        japaneseKu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hiraganaKatakana.isChecked()) {  ///カタカナ
                    words_EditText.setText(words_EditText.getText() + "ク");
                }
                else
                {
                    words_EditText.setText(words_EditText.getText() + "く");
                }
            }
        });



        japaneseKe=(Button)findViewById(R.id.japaneseKe);
        japaneseKe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hiraganaKatakana.isChecked()) {  ///カタカナ
                    words_EditText.setText(words_EditText.getText() + "ケ");
                }
                else
                {
                    words_EditText.setText(words_EditText.getText() + "け");
                }
            }
        });



        japaneseKo=(Button)findViewById(R.id.japaneseKo);
        japaneseKo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hiraganaKatakana.isChecked()) {  ///カタカナ
                    words_EditText.setText(words_EditText.getText() + "コ");
                }
                else
                {
                    words_EditText.setText(words_EditText.getText() + "こ");
                }
            }
        });



        japaneseGa=(Button)findViewById(R.id.japaneseGa);
        japaneseGa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hiraganaKatakana.isChecked()) {  ///カタカナ
                    words_EditText.setText(words_EditText.getText() + "ガ");
                }
                else
                {
                    words_EditText.setText(words_EditText.getText() + "が");
                }
            }
        });



        japaneseGi=(Button)findViewById(R.id. japaneseGi);
        japaneseGi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hiraganaKatakana.isChecked()) {  ///カタカナ
                    words_EditText.setText(words_EditText.getText() + "ギ");
                }
                else
                {
                    words_EditText.setText(words_EditText.getText() + "ぎ");
                }
            }
        });



        japaneseGu=(Button)findViewById(R.id.japaneseGu);
        japaneseGu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hiraganaKatakana.isChecked()) {  ///カタカナ
                    words_EditText.setText(words_EditText.getText() + "グ");
                }
                else
                {
                    words_EditText.setText(words_EditText.getText() + "ぐ");
                }
            }
        });


        japaneseGe=(Button)findViewById(R.id.japaneseGe);
        japaneseGe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hiraganaKatakana.isChecked()) {  ///カタカナ
                    words_EditText.setText(words_EditText.getText() + "ゲ");
                }
                else
                {
                    words_EditText.setText(words_EditText.getText() + "げ");
                }
            }
        });



        japaneseGo=(Button)findViewById(R.id.japaneseGo);
        japaneseGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hiraganaKatakana.isChecked()) {  ///カタカナ
                    words_EditText.setText(words_EditText.getText() + "ゴ");
                }
                else
                {
                    words_EditText.setText(words_EditText.getText() + "ご");
                }
            }
        });



        japaneseSa=(Button)findViewById(R.id.japaneseSa);
        japaneseSa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hiraganaKatakana.isChecked()) {  ///カタカナ
                    words_EditText.setText(words_EditText.getText() + "サ");
                }
                else
                {
                    words_EditText.setText(words_EditText.getText() + "さ");
                }
            }
        });



        japaneseShi=(Button)findViewById(R.id.japaneseShi);
        japaneseShi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hiraganaKatakana.isChecked()) {  ///カタカナ
                    words_EditText.setText(words_EditText.getText() + "シ");
                }
                else
                {
                    words_EditText.setText(words_EditText.getText() + "し");
                }
            }
        });



        japaneseSu=(Button)findViewById(R.id.japaneseSu);
        japaneseSu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hiraganaKatakana.isChecked()) {  ///カタカナ
                    words_EditText.setText(words_EditText.getText() + "ス");
                }
                else
                {
                    words_EditText.setText(words_EditText.getText() + "す");
                }
            }
        });



        japaneseSe=(Button)findViewById(R.id.japaneseSe);
        japaneseSe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hiraganaKatakana.isChecked()) {  ///カタカナ
                    words_EditText.setText(words_EditText.getText() + "セ");
                }
                else
                {
                    words_EditText.setText(words_EditText.getText() + "せ");
                }
            }
        });



        japaneseSo=(Button)findViewById(R.id.japaneseSo);
        japaneseSo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hiraganaKatakana.isChecked()) {  ///カタカナ
                    words_EditText.setText(words_EditText.getText() + "ソ");
                }
                else
                {
                    words_EditText.setText(words_EditText.getText() + "そ");
                }
            }
        });



        japaneseZa=(Button)findViewById(R.id.japaneseZa);
        japaneseZa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hiraganaKatakana.isChecked()) {  ///カタカナ
                    words_EditText.setText(words_EditText.getText() + "ザ");
                }
                else
                {
                    words_EditText.setText(words_EditText.getText() + "ざ");
                }
            }
        });



        japaneseJi=(Button)findViewById(R.id.japaneseJi);
        japaneseJi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hiraganaKatakana.isChecked()) {  ///カタカナ
                    words_EditText.setText(words_EditText.getText() + "ジ");
                }
                else
                {
                    words_EditText.setText(words_EditText.getText() + "じ");
                }
            }
        });



        japaneseZu=(Button)findViewById(R.id.japaneseZu);
        japaneseZu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hiraganaKatakana.isChecked()) {  ///カタカナ
                    words_EditText.setText(words_EditText.getText() + "ズ");
                }
                else
                {
                    words_EditText.setText(words_EditText.getText() + "ず");
                }
            }
        });



        japaneseZe=(Button)findViewById(R.id.japaneseZe);
        japaneseZe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hiraganaKatakana.isChecked()) {  ///カタカナ
                    words_EditText.setText(words_EditText.getText() + "ゼ");
                }
                else
                {
                    words_EditText.setText(words_EditText.getText() + "ぜ");
                }
            }
        });



        japaneseZo=(Button)findViewById(R.id.japaneseZo);
        japaneseZo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hiraganaKatakana.isChecked()) {  ///カタカナ
                    words_EditText.setText(words_EditText.getText() + "ゾ");
                }
                else
                {
                    words_EditText.setText(words_EditText.getText() + "ぞ");
                }
            }
        });



        japaneseTa=(Button)findViewById(R.id.japaneseTa);
        japaneseTa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hiraganaKatakana.isChecked()) {  ///カタカナ
                    words_EditText.setText(words_EditText.getText() + "タ");
                }
                else
                {
                    words_EditText.setText(words_EditText.getText() + "た");
                }
            }
        });



        japaneseChi=(Button)findViewById(R.id.japaneseChi);
        japaneseChi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hiraganaKatakana.isChecked()) {  ///カタカナ
                    words_EditText.setText(words_EditText.getText() + "チ");
                }
                else
                {
                    words_EditText.setText(words_EditText.getText() + "ち");
                }
            }
        });



        japaneseTsu=(Button)findViewById(R.id.japaneseTsu);
        japaneseTsu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hiraganaKatakana.isChecked()) {  ///カタカナ
                    words_EditText.setText(words_EditText.getText() + "ツ");
                }
                else
                {
                    words_EditText.setText(words_EditText.getText() + "つ");
                }
            }
        });



        japaneseTe=(Button)findViewById(R.id.japaneseTe);
        japaneseTe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hiraganaKatakana.isChecked()) {  ///カタカナ
                    words_EditText.setText(words_EditText.getText() + "テ");
                }
                else
                {
                    words_EditText.setText(words_EditText.getText() + "て");
                }
            }
        });



        japaneseTo=(Button)findViewById(R.id.japaneseTo);
        japaneseTo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hiraganaKatakana.isChecked()) {  ///カタカナ
                    words_EditText.setText(words_EditText.getText() + "ト");
                }
                else
                {
                    words_EditText.setText(words_EditText.getText() + "と");
                }
            }
        });



        japaneseDa=(Button)findViewById(R.id.japaneseDa);
        japaneseDa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hiraganaKatakana.isChecked()) {  ///カタカナ
                    words_EditText.setText(words_EditText.getText() + "ダ");
                }
                else
                {
                    words_EditText.setText(words_EditText.getText() + "だ");
                }
            }
        });



        japaneseChiJi=(Button)findViewById(R.id.japaneseChiJi);
        japaneseChiJi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hiraganaKatakana.isChecked()) {  ///カタカナ
                    words_EditText.setText(words_EditText.getText() + "ヂ");
                }
                else
                {
                    words_EditText.setText(words_EditText.getText() + "ぢ");
                }
            }
        });



        japaneseTsuZu=(Button)findViewById(R.id.japaneseTsuzu);
        japaneseTsuZu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hiraganaKatakana.isChecked()) {  ///カタカナ
                    words_EditText.setText(words_EditText.getText() + "ヅ");
                }
                else
                {
                    words_EditText.setText(words_EditText.getText() + "づ");
                }
            }
        });



        japaneseDe=(Button)findViewById(R.id.japaneseDe);
        japaneseDe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hiraganaKatakana.isChecked()) {  ///カタカナ
                    words_EditText.setText(words_EditText.getText() + "デ");
                }
                else
                {
                    words_EditText.setText(words_EditText.getText() + "で");
                }
            }
        });



        japaneseDo=(Button)findViewById(R.id.japaneseDo);
        japaneseDo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hiraganaKatakana.isChecked()) {  ///カタカナ
                    words_EditText.setText(words_EditText.getText() + "ド");
                }
                else
                {
                    words_EditText.setText(words_EditText.getText() + "ど");
                }
            }
        });



        japaneseNa=(Button)findViewById(R.id.japaneseNa);
        japaneseNa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hiraganaKatakana.isChecked()) {  ///カタカナ
                    words_EditText.setText(words_EditText.getText() + "ナ");
                }
                else
                {
                    words_EditText.setText(words_EditText.getText() + "な");
                }
            }
        });



        japaneseNi=(Button)findViewById(R.id.japaneseNi);
        japaneseNi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hiraganaKatakana.isChecked()) {  ///カタカナ
                    words_EditText.setText(words_EditText.getText() + "ニ");
                }
                else
                {
                    words_EditText.setText(words_EditText.getText() + "に");
                }
            }
        });



        japaneseNu=(Button)findViewById(R.id.japaneseNu);
        japaneseNu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hiraganaKatakana.isChecked()) {  ///カタカナ
                    words_EditText.setText(words_EditText.getText() + "ヌ");
                }
                else
                {
                    words_EditText.setText(words_EditText.getText() + "ぬ");
                }
            }
        });



        japaneseNe=(Button)findViewById(R.id.japaneseNe);
        japaneseNe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hiraganaKatakana.isChecked()) {  ///カタカナ
                    words_EditText.setText(words_EditText.getText() + "ネ");
                }
                else
                {
                    words_EditText.setText(words_EditText.getText() + "ね");
                }
            }
        });



        japaneseNo=(Button)findViewById(R.id.japaneseNo);
        japaneseNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hiraganaKatakana.isChecked()) {  ///カタカナ
                    words_EditText.setText(words_EditText.getText() + "ノ");
                }
                else
                {
                    words_EditText.setText(words_EditText.getText() + "の");
                }
            }
        });



        japaneseHa=(Button)findViewById(R.id.japaneseHa);
        japaneseHa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hiraganaKatakana.isChecked()) {  ///カタカナ
                    words_EditText.setText(words_EditText.getText() + "ハ");
                }
                else
                {
                    words_EditText.setText(words_EditText.getText() + "は");
                }
            }
        });



        japaneseHi=(Button)findViewById(R.id.japaneseHi);
        japaneseHi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hiraganaKatakana.isChecked()) {  ///カタカナ
                    words_EditText.setText(words_EditText.getText() + "ヒ");
                }
                else
                {
                    words_EditText.setText(words_EditText.getText() + "ひ");
                }
            }
        });



        japaneseFu=(Button)findViewById(R.id.japaneseFu);
        japaneseFu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hiraganaKatakana.isChecked()) {  ///カタカナ
                    words_EditText.setText(words_EditText.getText() + "フ");
                }
                else
                {
                    words_EditText.setText(words_EditText.getText() + "ふ");
                }
            }
        });



        japaneseHe=(Button)findViewById(R.id.japaneseHe);
        japaneseHe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hiraganaKatakana.isChecked()) {  ///カタカナ
                    words_EditText.setText(words_EditText.getText() + "ヘ");
                }
                else
                {
                    words_EditText.setText(words_EditText.getText() + "へ");
                }
            }
        });



        japaneseHo=(Button)findViewById(R.id.japaneseHo);
        japaneseHo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hiraganaKatakana.isChecked()) {  ///カタカナ
                    words_EditText.setText(words_EditText.getText() + "ホ");
                }
                else
                {
                    words_EditText.setText(words_EditText.getText() + "ほ");
                }
            }
        });



        japaneseBa=(Button)findViewById(R.id.japaneseBa);
        japaneseBa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hiraganaKatakana.isChecked()) {  ///カタカナ
                    words_EditText.setText(words_EditText.getText() + "バ");
                }
                else
                {
                    words_EditText.setText(words_EditText.getText() + "ば");
                }
            }
        });



        japaneseBi=(Button)findViewById(R.id.japaneseBi);
        japaneseBi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hiraganaKatakana.isChecked()) {  ///カタカナ
                    words_EditText.setText(words_EditText.getText() + "ビ");
                }
                else
                {
                    words_EditText.setText(words_EditText.getText() + "び");
                }
            }
        });



        japaneseBu=(Button)findViewById(R.id.japaneseBu);
        japaneseBu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hiraganaKatakana.isChecked()) {  ///カタカナ
                    words_EditText.setText(words_EditText.getText() + "ブ");
                }
                else
                {
                    words_EditText.setText(words_EditText.getText() + "ぶ");
                }
            }
        });



        japaneseBe=(Button)findViewById(R.id.japaneseBe);
        japaneseBe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hiraganaKatakana.isChecked()) {  ///カタカナ
                    words_EditText.setText(words_EditText.getText() + "ベ");
                }
                else
                {
                    words_EditText.setText(words_EditText.getText() + "べ");
                }
            }
        });



        japaneseBo=(Button)findViewById(R.id.japaneseBo);
        japaneseBo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hiraganaKatakana.isChecked()) {  ///カタカナ
                    words_EditText.setText(words_EditText.getText() + "ボ");
                }
                else
                {
                    words_EditText.setText(words_EditText.getText() + "ぼ");
                }
            }
        });



        japanesePa=(Button)findViewById(R.id.japanesePa);
        japanesePa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hiraganaKatakana.isChecked()) {  ///カタカナ
                    words_EditText.setText(words_EditText.getText() + "パ");
                }
                else
                {
                    words_EditText.setText(words_EditText.getText() + "ぱ");
                }
            }
        });



        japanesePi=(Button)findViewById(R.id.japanesePi);
        japanesePi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hiraganaKatakana.isChecked()) {  ///カタカナ
                    words_EditText.setText(words_EditText.getText() + "ピ");
                }
                else
                {
                    words_EditText.setText(words_EditText.getText() + "ぴ");
                }
            }
        });



        japanesePu=(Button)findViewById(R.id.japanesePu);
        japanesePu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hiraganaKatakana.isChecked()) {  ///カタカナ
                    words_EditText.setText(words_EditText.getText() + "プ");
                }
                else
                {
                    words_EditText.setText(words_EditText.getText() + "ぷ");
                }
            }
        });



        japanesePe=(Button)findViewById(R.id.japanesePe);
        japanesePe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hiraganaKatakana.isChecked()) {  ///カタカナ
                    words_EditText.setText(words_EditText.getText() + "ペ");
                }
                else
                {
                    words_EditText.setText(words_EditText.getText() + "ぺ");
                }
            }
        });



        japanesePo=(Button)findViewById(R.id.japanesePo);
        japanesePo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hiraganaKatakana.isChecked()) {  ///カタカナ
                    words_EditText.setText(words_EditText.getText() + "ポ");
                }
                else
                {
                    words_EditText.setText(words_EditText.getText() + "ぽ");
                }
            }
        });



        japaneseMa=(Button)findViewById(R.id.japaneseMa);
        japaneseMa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hiraganaKatakana.isChecked()) {  ///カタカナ
                    words_EditText.setText(words_EditText.getText() + "マ");
                }
                else
                {
                    words_EditText.setText(words_EditText.getText() + "ま");
                }
            }
        });



        japaneseMi=(Button)findViewById(R.id.japaneseMi);
        japaneseMi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hiraganaKatakana.isChecked()) {  ///カタカナ
                    words_EditText.setText(words_EditText.getText() + "ミ");
                }
                else
                {
                    words_EditText.setText(words_EditText.getText() + "み");
                }
            }
        });



        japaneseMu=(Button)findViewById(R.id.japaneseMu);
        japaneseMu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hiraganaKatakana.isChecked()) {  ///カタカナ
                    words_EditText.setText(words_EditText.getText() + "ム");
                }
                else
                {
                    words_EditText.setText(words_EditText.getText() + "む");
                }
            }
        });



        japaneseMe=(Button)findViewById(R.id.japaneseMe);
        japaneseMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hiraganaKatakana.isChecked()) {  ///カタカナ
                    words_EditText.setText(words_EditText.getText() + "メ");
                }
                else
                {
                    words_EditText.setText(words_EditText.getText() + "め");
                }
            }
        });



        japaneseMo=(Button)findViewById(R.id.japaneseMo);
        japaneseMo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hiraganaKatakana.isChecked()) {  ///カタカナ
                    words_EditText.setText(words_EditText.getText() + "モ");
                }
                else
                {
                    words_EditText.setText(words_EditText.getText() + "も");
                }
            }
        });



        japaneseYa=(Button)findViewById(R.id.japaneseYa);
        japaneseYa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hiraganaKatakana.isChecked()) {  ///カタカナ
                    words_EditText.setText(words_EditText.getText() + "ヤ");
                }
                else
                {
                    words_EditText.setText(words_EditText.getText() + "や");
                }
            }
        });



        japaneseYu=(Button)findViewById(R.id.japaneseYu);
        japaneseYu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hiraganaKatakana.isChecked()) {  ///カタカナ
                    words_EditText.setText(words_EditText.getText() + "ユ");
                }
                else
                {
                    words_EditText.setText(words_EditText.getText() + "ゆ");
                }
            }
        });



        japaneseYo=(Button)findViewById(R.id.japaneseYo);
        japaneseYo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hiraganaKatakana.isChecked()) {  ///カタカナ
                    words_EditText.setText(words_EditText.getText() + "ヨ");
                }
                else
                {
                    words_EditText.setText(words_EditText.getText() + "よ");
                }
            }
        });



        japaneseBackSpace=(Button)findViewById(R.id.japaneseBackSpace);
        japaneseBackSpace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textStringJapanese = words_EditText.getText().toString();
                if( textStringJapanese.length() > 0 )
                {
                    words_EditText.setText(textStringJapanese.substring(0, textStringJapanese.length() - 1));
                }
            }
        });



        japaneseRa=(Button)findViewById(R.id.japaneseRa);
        japaneseRa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hiraganaKatakana.isChecked()) {  ///カタカナ
                    words_EditText.setText(words_EditText.getText() + "ラ");
                }
                else
                {
                    words_EditText.setText(words_EditText.getText() + "ら");
                }
            }
        });


        japaneseRi=(Button)findViewById(R.id.japaneseRi);
        japaneseRi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hiraganaKatakana.isChecked()) {  ///カタカナ
                    words_EditText.setText(words_EditText.getText() + "リ");
                }
                else
                {
                    words_EditText.setText(words_EditText.getText() + "り");
                }
            }
        });



        japaneseRu=(Button)findViewById(R.id.japaneseRu);
        japaneseRu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hiraganaKatakana.isChecked()) {  ///カタカナ
                    words_EditText.setText(words_EditText.getText() + "ル");
                }
                else
                {
                    words_EditText.setText(words_EditText.getText() + "る");
                }
            }
        });



        japaneseRe=(Button)findViewById(R.id.japaneseRe);
        japaneseRe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hiraganaKatakana.isChecked()) {  ///カタカナ
                    words_EditText.setText(words_EditText.getText() + "レ");
                }
                else
                {
                    words_EditText.setText(words_EditText.getText() + "れ");
                }
            }
        });



        japaneseRo=(Button)findViewById(R.id.japaneseRo);
        japaneseRo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hiraganaKatakana.isChecked()) {  ///カタカナ
                    words_EditText.setText(words_EditText.getText() + "ロ");
                }
                else
                {
                    words_EditText.setText(words_EditText.getText() + "ろ");
                }
            }
        });



        japaneseWa=(Button)findViewById(R.id.japaneseWa);
        japaneseWa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hiraganaKatakana.isChecked()) {  ///カタカナ
                    words_EditText.setText(words_EditText.getText() + "ワ");
                }
                else
                {
                    words_EditText.setText(words_EditText.getText() + "わ");
                }
            }
        });



        japaneseSmallTsu=(Button)findViewById(R.id.japaneseSmallTsu);
        japaneseSmallTsu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hiraganaKatakana.isChecked()) {  ///カタカナ
                    words_EditText.setText(words_EditText.getText() + "ッ");
                }
                else
                {
                    words_EditText.setText(words_EditText.getText() + "っ");
                }
            }
        });



        japaneseN=(Button)findViewById(R.id.japaneseN);
        japaneseN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hiraganaKatakana.isChecked()) {  ///カタカナ
                    words_EditText.setText(words_EditText.getText() + "ン");
                }
                else
                {
                    words_EditText.setText(words_EditText.getText() + "ん");
                }
            }
        });



        japaneseParticleO=(Button)findViewById(R.id.japaneseParticleO);
        japaneseParticleO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hiraganaKatakana.isChecked()) {  ///カタカナ
                    words_EditText.setText(words_EditText.getText() + "ヲ");
                }
                else
                {
                    words_EditText.setText(words_EditText.getText() + "を");
                }
            }
        });



        japaneseSpace=(Button)findViewById(R.id.japaneseSpace);
        japaneseSpace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                words_EditText.setText(words_EditText.getText() + " ");
            }
        });



        japaneseKya=(Button)findViewById(R.id.japaneseKya);
        japaneseKya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hiraganaKatakana.isChecked()) {  ///カタカナ
                    words_EditText.setText(words_EditText.getText() + "キャ");
                }
                else
                {
                    words_EditText.setText(words_EditText.getText() + "きゃ");
                }
            }
        });



        japaneseKyu=(Button)findViewById(R.id.japaneseKyu);
        japaneseKyu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hiraganaKatakana.isChecked()) {  ///カタカナ
                    words_EditText.setText(words_EditText.getText() + "キュ");
                }
                else
                {
                    words_EditText.setText(words_EditText.getText() + "きゅ");
                }
            }
        });



        japaneseKyo=(Button)findViewById(R.id.japaneseKyo);
        japaneseKyo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hiraganaKatakana.isChecked()) {  ///カタカナ
                    words_EditText.setText(words_EditText.getText() + "キョ");
                }
                else
                {
                    words_EditText.setText(words_EditText.getText() + "きょ");
                }
            }
        });



        japaneseGya=(Button)findViewById(R.id.japaneseGya);
        japaneseGya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hiraganaKatakana.isChecked()) {  ///カタカナ
                    words_EditText.setText(words_EditText.getText() + "ギャ");
                }
                else
                {
                    words_EditText.setText(words_EditText.getText() + "ぎゃ");
                }
            }
        });



        japaneseGyu=(Button)findViewById(R.id.japaneseGyu);
        japaneseGyu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hiraganaKatakana.isChecked()) {  ///カタカナ
                    words_EditText.setText(words_EditText.getText() + "ギュ");
                }
                else
                {
                    words_EditText.setText(words_EditText.getText() + "ぎゅ");
                }
            }
        });



        japaneseGyo=(Button)findViewById(R.id.japaneseGyo);
        japaneseGyo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hiraganaKatakana.isChecked()) {  ///カタカナ
                    words_EditText.setText(words_EditText.getText() + "ギョ");
                }
                else
                {
                    words_EditText.setText(words_EditText.getText() + "ぎょ");
                }
            }
        });



        japaneseSha=(Button)findViewById(R.id.japaneseSha);
        japaneseSha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hiraganaKatakana.isChecked()) {  ///カタカナ
                    words_EditText.setText(words_EditText.getText() + "シャ");
                }
                else
                {
                    words_EditText.setText(words_EditText.getText() + "しゃ");
                }
            }
        });



        japaneseShu=(Button)findViewById(R.id.japaneseShu);
        japaneseShu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hiraganaKatakana.isChecked()) {  ///カタカナ
                    words_EditText.setText(words_EditText.getText() + "シュ");
                }
                else
                {
                    words_EditText.setText(words_EditText.getText() + "しゅ");
                }
            }
        });



        japaneseSho=(Button)findViewById(R.id.japaneseSho);
        japaneseSho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hiraganaKatakana.isChecked()) {  ///カタカナ
                    words_EditText.setText(words_EditText.getText() + "ショ");
                }
                else
                {
                    words_EditText.setText(words_EditText.getText() + "しょ");
                }
            }
        });



        japaneseJa=(Button)findViewById(R.id.japaneseJa);
        japaneseJa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hiraganaKatakana.isChecked()) {  ///カタカナ
                    words_EditText.setText(words_EditText.getText() + "ジャ");
                }
                else
                {
                    words_EditText.setText(words_EditText.getText() + "じゃ");
                }
            }
        });



        japaneseJu=(Button)findViewById(R.id.japaneseJu);
        japaneseJu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hiraganaKatakana.isChecked()) {  ///カタカナ
                    words_EditText.setText(words_EditText.getText() + "ジュ");
                }
                else
                {
                    words_EditText.setText(words_EditText.getText() + "じゅ");
                }
            }
        });



        japaneseJo=(Button)findViewById(R.id.japaneseJo);
        japaneseJo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hiraganaKatakana.isChecked()) {  ///カタカナ
                    words_EditText.setText(words_EditText.getText() + "ジョ");
                }
                else
                {
                    words_EditText.setText(words_EditText.getText() + "じょ");
                }
            }
        });



        japaneseCha=(Button)findViewById(R.id.japaneseCha);
        japaneseCha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hiraganaKatakana.isChecked()) {  ///カタカナ
                    words_EditText.setText(words_EditText.getText() + "チャ");
                }
                else
                {
                    words_EditText.setText(words_EditText.getText() + "ちゃ");
                }
            }
        });



        japaneseChu=(Button)findViewById(R.id.japaneseChu);
        japaneseChu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hiraganaKatakana.isChecked()) {  ///カタカナ
                    words_EditText.setText(words_EditText.getText() + "チュ");
                }
                else
                {
                    words_EditText.setText(words_EditText.getText() + "ちゅ");
                }
            }
        });



        japaneseCho=(Button)findViewById(R.id.japaneseCho);
        japaneseCho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hiraganaKatakana.isChecked()) {  ///カタカナ
                    words_EditText.setText(words_EditText.getText() + "チョ");
                }
                else
                {
                    words_EditText.setText(words_EditText.getText() + "ちょ");
                }
            }
        });



        japaneseNya=(Button)findViewById(R.id.japaneseNya);
        japaneseNya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hiraganaKatakana.isChecked()) {  ///カタカナ
                    words_EditText.setText(words_EditText.getText() + "ニャ");
                }
                else
                {
                    words_EditText.setText(words_EditText.getText() + "にゃ");
                }
            }
        });



        japaneseNyu=(Button)findViewById(R.id.japaneseNyu);
        japaneseNyu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hiraganaKatakana.isChecked()) {  ///カタカナ
                    words_EditText.setText(words_EditText.getText() + "ニュ");
                }
                else
                {
                    words_EditText.setText(words_EditText.getText() + "にゅ");
                }
            }
        });



        japaneseNyo=(Button)findViewById(R.id.japaneseNyo);
        japaneseNyo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hiraganaKatakana.isChecked()) {  ///カタカナ
                    words_EditText.setText(words_EditText.getText() + "ニョ");
                }
                else
                {
                    words_EditText.setText(words_EditText.getText() + "にょ");
                }
            }
        });



        japaneseHya=(Button)findViewById(R.id.japaneseHya);
        japaneseHya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hiraganaKatakana.isChecked()) {  ///カタカナ
                    words_EditText.setText(words_EditText.getText() + "ヒャ");
                }
                else
                {
                    words_EditText.setText(words_EditText.getText() + "ひゃ");
                }
            }
        });



        japaneseHyu=(Button)findViewById(R.id.japaneseHyu);
        japaneseHyu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hiraganaKatakana.isChecked()) {  ///カタカナ
                    words_EditText.setText(words_EditText.getText() + "ヒュ");
                }
                else
                {
                    words_EditText.setText(words_EditText.getText() + "ひゅ");
                }
            }
        });



        japaneseHyo=(Button)findViewById(R.id.japaneseHyo);
        japaneseHyo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hiraganaKatakana.isChecked()) {  ///カタカナ
                    words_EditText.setText(words_EditText.getText() + "ヒョ");
                }
                else
                {
                    words_EditText.setText(words_EditText.getText() + "ひょ");
                }
            }
        });



        japaneseBya=(Button)findViewById(R.id.japaneseBya);
        japaneseBya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hiraganaKatakana.isChecked()) {  ///カタカナ
                    words_EditText.setText(words_EditText.getText() + "ビャ");
                }
                else
                {
                    words_EditText.setText(words_EditText.getText() + "びゃ");
                }
            }
        });



        japaneseByu=(Button)findViewById(R.id.japaneseByu);
        japaneseByu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hiraganaKatakana.isChecked()) {  ///カタカナ
                    words_EditText.setText(words_EditText.getText() + "ビュ");
                }
                else
                {
                    words_EditText.setText(words_EditText.getText() + "びゅ");
                }
            }
        });



        japaneseByo=(Button)findViewById(R.id.japaneseByo);
        japaneseByo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hiraganaKatakana.isChecked()) {  ///カタカナ
                    words_EditText.setText(words_EditText.getText() + "ビョ");
                }
                else
                {
                    words_EditText.setText(words_EditText.getText() + "びょ");
                }
            }
        });



        japanesePya=(Button)findViewById(R.id.japanesePya);
        japanesePya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hiraganaKatakana.isChecked()) {  ///カタカナ
                    words_EditText.setText(words_EditText.getText() + "ピャ");
                }
                else
                {
                    words_EditText.setText(words_EditText.getText() + "ぴゃ");
                }
            }
        });



        japanesePyu=(Button)findViewById(R.id.japanesePyu);
        japanesePyu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hiraganaKatakana.isChecked()) {  ///カタカナ
                    words_EditText.setText(words_EditText.getText() + "ピュ");
                }
                else
                {
                    words_EditText.setText(words_EditText.getText() + "ぴゅ");
                }
            }
        });



        japanesePyo=(Button)findViewById(R.id.japanesePyo);
        japanesePyo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hiraganaKatakana.isChecked()) {  ///カタカナ
                    words_EditText.setText(words_EditText.getText() + "ピョ");
                }
                else
                {
                    words_EditText.setText(words_EditText.getText() + "ぴょ");
                }
            }
        });



        japaneseMya=(Button)findViewById(R.id.japaneseMya);
        japaneseMya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hiraganaKatakana.isChecked()) {  ///カタカナ
                    words_EditText.setText(words_EditText.getText() + "ミャ");
                }
                else
                {
                    words_EditText.setText(words_EditText.getText() + "みゃ");
                }
            }
        });



        japaneseMyu=(Button)findViewById(R.id.japaneseMyu);
        japaneseMyu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hiraganaKatakana.isChecked()) {  ///カタカナ
                    words_EditText.setText(words_EditText.getText() + "ミュ");
                }
                else
                {
                    words_EditText.setText(words_EditText.getText() + "みゅ");
                }
            }
        });



        japaneseMyo=(Button)findViewById(R.id.japaneseMyo);
        japaneseMyo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hiraganaKatakana.isChecked()) {  ///カタカナ
                    words_EditText.setText(words_EditText.getText() + "ミョ");
                }
                else
                {
                    words_EditText.setText(words_EditText.getText() + "みょ");
                }
            }
        });



        japaneseRya=(Button)findViewById(R.id.japaneseRya);
        japaneseRya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hiraganaKatakana.isChecked()) {  ///カタカナ
                    words_EditText.setText(words_EditText.getText() + "リャ");
                }
                else
                {
                    words_EditText.setText(words_EditText.getText() + "りゃ");
                }
            }
        });



        japaneseRyu=(Button)findViewById(R.id.japaneseRyu);
        japaneseRyu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hiraganaKatakana.isChecked()) {  ///カタカナ
                    words_EditText.setText(words_EditText.getText() + "リュ");
                }
                else
                {
                    words_EditText.setText(words_EditText.getText() + "りゅ");
                }
            }
        });



        japaneseRyo=(Button)findViewById(R.id.japaneseRyo);
        japaneseRyo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hiraganaKatakana.isChecked()) {  ///カタカナ
                    words_EditText.setText(words_EditText.getText() + "リョ");
                }
                else
                {
                    words_EditText.setText(words_EditText.getText() + "りょ");
                }
            }
        });



        japaneseSmallA =(Button)findViewById(R.id.japaneseSmallA);
        japaneseSmallA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hiraganaKatakana.isChecked()) {  ///カタカナ
                    words_EditText.setText(words_EditText.getText() + "ァ");
                }
            }
        });



        japaneseSmallI=(Button)findViewById(R.id.japaneseSmallI);
        japaneseSmallI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hiraganaKatakana.isChecked()) {  ///カタカナ
                    words_EditText.setText(words_EditText.getText() + "ィ");
                }
            }
        });



        japaneseSmallU=(Button)findViewById(R.id.japaneseSmallU);
        japaneseSmallU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hiraganaKatakana.isChecked()) {  ///カタカナ
                    words_EditText.setText(words_EditText.getText() + "ゥ");
                }
            }
        });



        japaneseSmallE=(Button)findViewById(R.id.japaneseSmallE);
        japaneseSmallE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hiraganaKatakana.isChecked()) {  ///カタカナ
                    words_EditText.setText(words_EditText.getText() + "ェ");
                }
            }
        });



        japaneseSmallO=(Button)findViewById(R.id.japaneseSmallO);
        japaneseSmallO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hiraganaKatakana.isChecked()) {  ///カタカナ
                    words_EditText.setText(words_EditText.getText() + "ォ");
                }
            }
        });



        japaneseDash=(Button)findViewById(R.id.japaneseDash);
        japaneseDash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hiraganaKatakana.isChecked()) {  ///カタカナ
                    words_EditText.setText(words_EditText.getText() + "ー");
                }
            }
        });





        englishA=(Button)findViewById(R.id.englishA);
        englishA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getLength();
                if (lengthCounter==0 || spaceCounter>=1)
                {
                    word_meanings_EditText.setText(word_meanings_EditText.getText() + "A");
                }
                else
                {
                    word_meanings_EditText.setText(word_meanings_EditText.getText() + "a");
                }
                spaceCounter=0;
            }
        });



        englishB=(Button)findViewById(R.id.englishB);
        englishB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getLength();
                if (lengthCounter==0 || spaceCounter>=1)
                {
                    word_meanings_EditText.setText(word_meanings_EditText.getText() + "B");
                }
                else
                {
                    word_meanings_EditText.setText(word_meanings_EditText.getText() + "b");
                }
                spaceCounter=0;
            }
        });



        englishC=(Button)findViewById(R.id.englishC);
        englishC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getLength();
                if (lengthCounter==0 || spaceCounter>=1)
                {
                    word_meanings_EditText.setText(word_meanings_EditText.getText() + "C");
                }
                else
                {
                    word_meanings_EditText.setText(word_meanings_EditText.getText() + "c");
                }
                spaceCounter=0;
            }
        });



        englishD=(Button)findViewById(R.id.englishD);
        englishD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getLength();
                if (lengthCounter==0 || spaceCounter>=1)
                {
                    word_meanings_EditText.setText(word_meanings_EditText.getText() + "D");
                }
                else
                {
                    word_meanings_EditText.setText(word_meanings_EditText.getText() + "d");
                }
                spaceCounter=0;
            }
        });



        englishE=(Button)findViewById(R.id.englishE);
        englishE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getLength();
                if (lengthCounter==0 || spaceCounter>=1)
                {
                    word_meanings_EditText.setText(word_meanings_EditText.getText() + "E");
                }
                else
                {
                    word_meanings_EditText.setText(word_meanings_EditText.getText() + "e");
                }
                spaceCounter=0;
            }
        });



        englishF=(Button)findViewById(R.id.englishF);
        englishF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getLength();
                if (lengthCounter==0 || spaceCounter>=1)
                {
                    word_meanings_EditText.setText(word_meanings_EditText.getText() + "F");
                }
                else
                {
                    word_meanings_EditText.setText(word_meanings_EditText.getText() + "f");
                }
                spaceCounter=0;
            }
        });



        englishG=(Button)findViewById(R.id.englishG);
        englishG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getLength();
                if (lengthCounter==0 || spaceCounter>=1)
                {
                    word_meanings_EditText.setText(word_meanings_EditText.getText() + "G");
                }
                else
                {
                    word_meanings_EditText.setText(word_meanings_EditText.getText() + "g");
                }
                spaceCounter=0;
            }
        });



        englishH=(Button)findViewById(R.id.englishH);
        englishH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getLength();
                if (lengthCounter==0 || spaceCounter>=1)
                {
                    word_meanings_EditText.setText(word_meanings_EditText.getText() + "H");
                }
                else
                {
                    word_meanings_EditText.setText(word_meanings_EditText.getText() + "h");
                }
                spaceCounter=0;
            }
        });



        englishI=(Button)findViewById(R.id.englishI);
        englishI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getLength();
                if (lengthCounter==0 || spaceCounter>=1)
                {
                    word_meanings_EditText.setText(word_meanings_EditText.getText() + "I");
                }
                else
                {
                    word_meanings_EditText.setText(word_meanings_EditText.getText() + "i");
                }
                spaceCounter=0;
            }
        });



        englishJ=(Button)findViewById(R.id.englishJ);
        englishJ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getLength();
                if (lengthCounter==0 || spaceCounter>=1)
                {
                    word_meanings_EditText.setText(word_meanings_EditText.getText() + "J");
                }
                else
                {
                    word_meanings_EditText.setText(word_meanings_EditText.getText() + "j");
                }
                spaceCounter=0;
            }
        });



        englishK=(Button)findViewById(R.id.englishK);
        englishK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getLength();
                if (lengthCounter==0 || spaceCounter>=1)
                {
                    word_meanings_EditText.setText(word_meanings_EditText.getText() + "K");
                }
                else
                {
                    word_meanings_EditText.setText(word_meanings_EditText.getText() + "k");
                }
                spaceCounter=0;
            }
        });



        englishL=(Button)findViewById(R.id.englishL);
        englishL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getLength();
                if (lengthCounter==0 || spaceCounter>=1)
                {
                    word_meanings_EditText.setText(word_meanings_EditText.getText() + "L");
                }
                else
                {
                    word_meanings_EditText.setText(word_meanings_EditText.getText() + "l");
                }
                spaceCounter=0;
            }
        });



        englishM=(Button)findViewById(R.id.englishM);
        englishM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getLength();
                if (lengthCounter==0 || spaceCounter>=1)
                {
                    word_meanings_EditText.setText(word_meanings_EditText.getText() + "M");
                }
                else
                {
                    word_meanings_EditText.setText(word_meanings_EditText.getText() + "m");
                }
                spaceCounter=0;
            }
        });



        englishN=(Button)findViewById(R.id.englishN);
        englishN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getLength();
                if (lengthCounter==0 || spaceCounter>=1)
                {
                    word_meanings_EditText.setText(word_meanings_EditText.getText() + "N");
                }
                else
                {
                    word_meanings_EditText.setText(word_meanings_EditText.getText() + "n");
                }
                spaceCounter=0;
            }
        });



        englishO=(Button)findViewById(R.id.englishO);
        englishO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getLength();
                if (lengthCounter==0 || spaceCounter>=1)
                {
                    word_meanings_EditText.setText(word_meanings_EditText.getText() + "O");
                }
                else
                {
                    word_meanings_EditText.setText(word_meanings_EditText.getText() + "o");
                }
                spaceCounter=0;
            }
        });



        englishP=(Button)findViewById(R.id.englishP);
        englishP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getLength();
                if (lengthCounter==0 || spaceCounter>=1)
                {
                    word_meanings_EditText.setText(word_meanings_EditText.getText() + "P");
                }
                else
                {
                    word_meanings_EditText.setText(word_meanings_EditText.getText() + "p");
                }
                spaceCounter=0;
            }
        });



        englishQ=(Button)findViewById(R.id.englishQ);
        englishQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getLength();
                if (lengthCounter==0 || spaceCounter>=1)
                {
                    word_meanings_EditText.setText(word_meanings_EditText.getText() + "Q");
                }
                else
                {
                    word_meanings_EditText.setText(word_meanings_EditText.getText() + "q");
                }
                spaceCounter=0;
            }
        });



        englishR=(Button)findViewById(R.id.englishR);
        englishR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getLength();
                if (lengthCounter==0 || spaceCounter>=1)
                {
                    word_meanings_EditText.setText(word_meanings_EditText.getText() + "R");
                }
                else
                {
                    word_meanings_EditText.setText(word_meanings_EditText.getText() + "r");
                }
                spaceCounter=0;
            }
        });



        englishS=(Button)findViewById(R.id.englishS);
        englishS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getLength();
                if (lengthCounter==0 || spaceCounter>=1)
                {
                    word_meanings_EditText.setText(word_meanings_EditText.getText() + "S");
                }
                else
                {
                    word_meanings_EditText.setText(word_meanings_EditText.getText() + "s");
                }
                spaceCounter=0;
            }
        });



        englishT=(Button)findViewById(R.id.englishT);
        englishT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getLength();
                if (lengthCounter==0 || spaceCounter>=1)
                {
                    word_meanings_EditText.setText(word_meanings_EditText.getText() + "T");
                }
                else
                {
                    word_meanings_EditText.setText(word_meanings_EditText.getText() + "t");
                }
                spaceCounter=0;
            }
        });



        englishU=(Button)findViewById(R.id.englishU);
        englishU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getLength();
                if (lengthCounter==0 || spaceCounter>=1)
                {
                    word_meanings_EditText.setText(word_meanings_EditText.getText() + "U");
                }
                else
                {
                    word_meanings_EditText.setText(word_meanings_EditText.getText() + "u");
                }
                spaceCounter=0;
            }
        });



        englishV=(Button)findViewById(R.id.englishV);
        englishV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getLength();
                if (lengthCounter==0 || spaceCounter>=1)
                {
                    word_meanings_EditText.setText(word_meanings_EditText.getText() + "V");
                }
                else
                {
                    word_meanings_EditText.setText(word_meanings_EditText.getText() + "v");
                }
                spaceCounter=0;
            }
        });



        englishW=(Button)findViewById(R.id.englishW);
        englishW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getLength();
                if (lengthCounter==0 || spaceCounter>=1)
                {
                    word_meanings_EditText.setText(word_meanings_EditText.getText() + "W");
                }
                else
                {
                    word_meanings_EditText.setText(word_meanings_EditText.getText() + "w");
                }
                spaceCounter=0;
            }
        });



        englishX=(Button)findViewById(R.id.englishX);
        englishX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getLength();
                if (lengthCounter==0 || spaceCounter>=1)
                {
                    word_meanings_EditText.setText(word_meanings_EditText.getText() + "X");
                }
                else
                {
                    word_meanings_EditText.setText(word_meanings_EditText.getText() + "x");
                }
                spaceCounter=0;
            }
        });



        englishY=(Button)findViewById(R.id.englishY);
        englishY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getLength();
                if (lengthCounter==0 || spaceCounter>=1)
                {
                    word_meanings_EditText.setText(word_meanings_EditText.getText() + "Y");
                }
                else
                {
                    word_meanings_EditText.setText(word_meanings_EditText.getText() + "y");
                }
                spaceCounter=0;
            }
        });



        englishZ=(Button)findViewById(R.id.englishZ);
        englishZ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getLength();
                if (lengthCounter==0 || spaceCounter>=1)
                {
                    word_meanings_EditText.setText(word_meanings_EditText.getText() + "Z");
                }
                else
                {
                    word_meanings_EditText.setText(word_meanings_EditText.getText() + "z");
                }
                spaceCounter=0;
            }
        });



        englishBackSpace=(Button)findViewById(R.id.englishBackSpace);
        englishBackSpace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textStringEnglish = word_meanings_EditText.getText().toString();
                if( textStringEnglish.length() > 0 )
                {
                    word_meanings_EditText.setText(textStringEnglish.substring(0, textStringEnglish.length() - 1));
                }
            }
        });



        englishSpace=(Button)findViewById(R.id.englishSpace);
        englishSpace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                word_meanings_EditText.setText(word_meanings_EditText.getText() + " ");
                spaceCounter++;
            }
        });*/

    }

    /*public void getLength() {
        lengthCounter=word_meanings_EditText.length();
    }*/



    @Override
    public void onClick(View view) {

    String words = words_EditText.getText().toString();
    String word_meanings = word_meanings_EditText.getText().toString();

        if (view.getId()==R.id.add_words)
        {
            if (words.equals("") && word_meanings.equals("") || words.equals("")) {
                Toast.makeText(getApplicationContext(), "Please Enter Words.", Toast.LENGTH_SHORT).show();
            }

            else {
                long rowID = database_helper.AddWords(words, word_meanings);
                if (rowID > -1) {
                    Toast.makeText(getApplicationContext(), "Added.", Toast.LENGTH_SHORT).show();
                    words_EditText.setText("");
                    word_meanings_EditText.setText("");
                }

                else
                {
                    Toast.makeText(getApplicationContext(), "Not Added.", Toast.LENGTH_SHORT).show();
                }
            }
        }


        else if(view.getId()==R.id.view_words)
        {
            Intent intent = new Intent(Add_Words_Button.this,View_Words_Button.class);
            startActivity(intent);
        }

        else if(view.getId()==R.id.update_words)
        {
            Boolean isUpdated = database_helper.UpdateWords(words,word_meanings);

            if (words.equals("") && word_meanings.equals("") || words.equals(""))
            {
                Toast.makeText(getApplicationContext(), "Please Enter Words.", Toast.LENGTH_SHORT).show();
            }
            else
            {
                if (isUpdated == true)
                {
                    Toast.makeText(getApplicationContext(), "Updated.", Toast.LENGTH_SHORT).show();
                    words_EditText.setText("");
                    word_meanings_EditText.setText("");
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Not Updated.", Toast.LENGTH_SHORT).show();
                }
            }
        }

        else if (view.getId()==R.id.delete_words)
        {
            int value = database_helper.DeleteWords(words);
            if (value>0)
            {
                Toast.makeText(getApplicationContext(),"Deleted.",Toast.LENGTH_SHORT).show();
                words_EditText.setText("");
                word_meanings_EditText.setText("");
            }

            else
            {
                Toast.makeText(getApplicationContext(),"Not Deleted.",Toast.LENGTH_SHORT).show();
            }
        }

        else if (view.getId()==R.id.clear_words)
        {

                words_EditText.setText("");
                word_meanings_EditText.setText("");
        }
    }
}


        /*words_EditText.setInputType(InputType.TYPE_NULL);
        word_meanings_EditText.setInputType(InputType.TYPE_NULL);*/
