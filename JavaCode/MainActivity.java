package com.example.healthcaremain;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnexe, btntip;

    View dev;
    private FirebaseAuth mAuth;


    BottomNavigationView bottomNavigationView; //바텀 네비게이션 뷰
    //FragmentTip frameLayouttip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setIcon(R.drawable.wannabe2);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();


        bottomNavigationView = findViewById(R.id.bottomnavi);
        bottomNavigationView.setItemIconTintList(null);


        //처음화면
        getSupportFragmentManager().beginTransaction().add(R.id.main_layout, new Fragment1()).commit(); //FrameLayout에 fragment.xml 띄우기

        //바텀 네비게이션뷰 안의 아이템 설정
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    //item을 클릭시 id값을 가져와 FrameLayout에 fragment.xml띄우기
                    case R.id.item_home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_layout, new Fragment1()).commit();
                        break;
                    case R.id.item_sleep:
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_layout, new Fragment2()).commit();
                        break;
                    case R.id.item_meal:
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_layout, new Fragment3()).commit();
                        break;
                    case R.id.item_exe:
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_layout, new Fragment4()).commit();
                        break;
                    case R.id.item_plan:
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_layout, new Fragment5()).commit();
                        break;
                }
                return true;
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null) {
            currentUser.reload();
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.Info:
                Intent Info = new Intent(getApplicationContext(), MyInfoActivity.class);
                startActivity(Info);
                break;
            case R.id.Qna:
                Intent Qna = new Intent(Intent.ACTION_SEND);
                Qna.setType("plain/text");
                String[] address = {"ykd3003@naver.com"};
                Qna.putExtra(Intent.EXTRA_EMAIL, address);
                Qna.putExtra(Intent.EXTRA_SUBJECT, "id@address.com");
                Qna.putExtra(Intent.EXTRA_TEXT, "내용 미리보기");
                startActivity(Qna);
                break;
            case R.id.Developer:
                AlertDialog.Builder developer = new AlertDialog.Builder(this);
                developer.setTitle("개발").setMessage("노영준 : \n정인태 : \n임혜주 : ");
                developer.setPositiveButton("확인", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int id)
                    {
                    }
                });
                developer.setNegativeButton("취소", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int id)
                    {
                    }
                });
                AlertDialog alertDialog2 = developer.create();
                alertDialog2.show();
                break;
            case R.id.Terms:
                AlertDialog.Builder terms = new AlertDialog.Builder(this);
                terms.setTitle("이용약관 및 정책").setMessage("1.본 약관은 '갑'에 회원 가입 시 회원들에게 통지함으로써 효력을 발생합니다.\n" +
                        "\n" +
                        "2.'갑'은 이 약관의 내용을 변경할 수 있으며, 변경된 약관은 제1항과 같은 방법으로 공지 또는 통지함으로써 효력을 발생합니다.\n" +
                        "\n" +
                        "3.약관의 변경사항 및 내용은 '갑'의 홈페이지에 게시하는 방법으로 공시합니다.\n" +
                        "\n" +
                        "\n" +
                        "제3조 (약관 이외의 준칙)\n" +
                        "\n" +
                        "이 약관에 명시되지 않은 사항이 전기 통신 기본법, 전기통신 사업법, 기타 관련 법령에 규정되어 있는 경우 그 규정에 따릅니다.\n" +
                        "\n" +
                        "\n" +
                        "제4조 (이용계약의 체결)\n" +
                        "\n" +
                        "회원 가입 시 회원 약관 밑에 있는 동의버튼을 누르면 약관에 동의하여 이 계약이 체결된 것으로 간주한다.\n" +
                        "\n" +
                        "\n" +
                        "제5조 (용어의 정의)\n" +
                        "\n" +
                        "이 약관에서 사용하는 용어의 정의는 다음과 같습니다.\n" +
                        "\n" +
                        "1.회원: '갑'과 서비스 이용에 관한 계약을 체결한 자\n" +
                        "\n" +
                        "2.아이디(ID): 회원 식별과 회원의 서비스 이용을 위하여 회원이 선정하고 '갑'이 승인하는 문자와 숫자의 조합\n" +
                        "\n" +
                        "3.비밀번호: 회원이 통신상의 자신의 비밀을 보호하기 위해 선정한 문자와 숫자의 조합\n" +
                        "\n" +
                        "\n" +
                        "\n" +
                        "제6조 (이용신청)\n" +
                        "\n" +
                        "1.회원 가입은 온라인으로 가입신청 양식에 기록하여 '갑'에 제출함으로써 이용신청을 할 수 있습니다.\n" +
                        "\n" +
                        "2.가입희망 회원은 반드시 자신의 본명 및 주민등록번호로 이용신청을 하여야 하며, 1개의 ID만 신청을 할 수 있습니다.\n" +
                        "\n" +
                        "\n" +
                        "\n" +
                        "제7조 (회원가입의 승낙)\n" +
                        "\n" +
                        "'갑'의 회원 가입 신청 양식에 가입 희망 회원이 인터넷으로 제6조와 같이 신청하면 '갑'은 바로 가입을 승인하여 서비스를 이용할 수 있다.\n" +
                        "\n" +
                        "\n" +
                        "제8조(회원가입 신청거절 및 강제 탈퇴)\n" +
                        "\n" +
                        "1. '갑'은 타인의 명의나 주민등록번호를 도용하여 회원가입신청을 할 경우 회원가입신청을 거절할 수 있다.\n" +
                        "2. 회원가입신청이 승인이 된 후에도 허위사실의 기재가 발각되거나 '갑'의 명예를 회손시키거나 음란물이나 불건전한 내용을 게재할 경우 회원의 자격을 강제 탈퇴시킬 수 있다.\n" +
                        "\n" +
                        "\n" +
                        "제9조 (서비스 제공의 중지)\n" +
                        "\n" +
                        "'갑'은 다음 각 호의 1에 해당하는 경우 서비스의 제공을 중지할 수 있습니다\n" +
                        "\n" +
                        "1.설비의 보수 등을 위하여 부득이한 경우 \n" +
                        "\n" +
                        "2.전기통신사업법에 규정된 기간통신사업자가 전기통신서비스를 중지하는 경우 \n" +
                        "\n" +
                        "3.기타 '갑'이 서비스를 제공할 수 없는 사유가 발생한 경우.\n" +
                        "\n" +
                        "\n" +
                        "제10조 ('갑'의 의무)\n" +
                        "\n" +
                        "1. '갑'은  계속적, 안정적으로 서비스를 제공할 수 있도록 최선의 노력을 다하여야 합니다.\n" +
                        "\n" +
                        "\n" +
                        "2.'갑'은 항상 회원의 신용정보를 포함한 개인신상정보의 보안에 대하여 관리에 만전을 기함으로서 회원의 정보보안에 최선을 다하여야 합니다.   \n" +
                        "\n" +
                        "\n" +
                        "제11조 (개인정보보호)\n" +
                        "\n" +
                        "1.'갑'은 이용자의 정보수집시 서비스의 제공에 필요한 최소한의 정보를 수집합니다. \n" +
                        "\n" +
                        "2.제공된 개인정보는 당해 이용자의 동의없이 목적외의 이용이나  제3자에게 제공할 수 없으며, 이에 대한 모든 책임은 '갑'이 집니다. 다만, 다음의 경우에는 예외로 합니다. \n" +
                        " ①통계작성, 학술연구 또는 시장조사를 위하여 필요한 경우로서 특정 개인을 식별할 수 없는 형태로 제공하는 경우  \n" +
                        " ②전기통신기본법 등 법률의 규정에 의해 국가기관의 요구가 있는 경우\n" +
                        " ③범죄에 대한 수사상의 목적이 있거나 정보통신윤리 위원회의 요청이 있는 경우\n" +
                        " ④기타 관계법령에서 정한 절차에 따른 요청이 있는 경우\n" +
                        "\n" +
                        "\n" +
                        "3.회원은 언제든지 '갑'이 가지고 있는 자신의 개인정보에 대해 열람 및 오류정정을 요구할 수 있으며 '갑'은 이에 대해 지체없이 처리합니다.\n" +
                        "\n" +
                        "\n" +
                        "\n" +
                        "제12조 (회원의 의무)\n" +
                        "\n" +
                        "1.회원은 관계법령, 이 약관의 규정, 이용안내 및 주의사항 등 '갑'이 통지하는 사항을 준수하여야 하며, 기타 '갑'의 업무에 방해되는 행위를 하여서는 안됩니다.\n" +
                        "\n" +
                        "2.회원은 '갑'의 사전 승낙 없이 서비스를 이용하여 어떠한 영리 행위도 할 수 없습니다.\n" +
                        "\n" +
                        "3.회원은 서비스를 이용하여 얻은 정보를 '갑'의 사전 승낙 없이 복사, 복제, 변경, 번역, 출판,방송 기타의 방법으로 사용하거나 이를 타인에게 제공할 수 없습니다.\n" +
                        "\n" +
                        "4.회원은 이용신청서의 기재내용 중 변경된 내용이 있는 경우 서비스를 통하여 그 내용을 '갑'에게 통지하여야 합니다.\n" +
                        "\n" +
                        "5.회원은 서비스 이용과 관련하여 다음 각 호의 행위를 하여서는 안됩니다. \n" +
                        "  ①다른 회원의 아이디(ID)를 부정 사용하는 행위 \n" +
                        "  ②범죄행위를 목적으로 하거나 기타 범죄행위와 관련된 행위 \n" +
                        "  ③선량한 풍속, 기타 사회질서를 해하는 행위\n" +
                        "  ④타인의 명예를 훼손하거나 모욕하는 행위  \n" +
                        "  ⑤타인의 지적재산권 등의 권리를 침해하는 행위 \n" +
                        "  ⑥해킹행위 또는 컴퓨터바이러스의 유포행위  \n" +
                        "  ⑦타인의 의사에 반하여 광고성 정보 등 일정한 내용을 지속적으로 전송 또는 타 사이트를 링크하는 행위  \n" +
                        "  ⑧서비스의 안전적인 운영에 지장을 주거나 줄 우려가 있는 일체의 행위\n" +
                        "  ⑨기타 관계법령에 위배되는 행위  \n" +
                        "  ⑩게시판 등 커뮤니티를 통한 상업적 광고홍보 또는 상거래 행위\n" +
                        "\n" +
                        "\n" +
                        "제13조 (게시물 또는 내용물의 삭제) \n" +
                        "\n" +
                        "'갑'은 서비스의 게시물 또는 내용물이 제12조의 규정에 위반되거나 '갑' 소정의 게시기간을 초과하는 경우 사전 통지나 동의 없이 이를 삭제할 수 있습니다.\n" +
                        "\n" +
                        "\n" +
                        "제14조 (게시물에 대한 권리·의무)\n" +
                        "\n" +
                        "게시물에 대한 저작권을 포함한 모든 권리 및 책임은 이를 게시한 회원에게 있습니다.\n" +
                        "\n" +
                        "\n" +
                        "제15조 (양도금지)\n" +
                        "\n" +
                        "회원이 서비스의 이용권한, 기타 이용계약상 지위를 타인에게 양도, 증여할 수 없으며, 이를 담보로 제공할 수 없습니다.\n" +
                        "\n" +
                        "\n" +
                        "제16조 (계약해지 및 이용제한) \n" +
                        "\n" +
                        "1.회원이 이용계약을 해지하고자 하는 때에는 본인이 서비스 또는 전자 우편을 통하여 해지하고자 하는 날의 1일전까지 (단, 해지일이 법정 공휴일인 경우 공휴일 개시 2일전까지)이를 '갑'에게 신청하여야 합니다.\n" +
                        "\n" +
                        "2.'갑'은 해지 및 탈퇴를 한 회원이 다시 이용신청을 하는 경우 일정기간 그 승낙을 제한할 수 있습니다.\n" +
                        "\n" +
                        "\n" +
                        "\n" +
                        "\n" +
                        "제17조 (면책·배상)\n" +
                        "\n" +
                        "1.'갑'은 회원이 서비스에 게재한 정보, 자료, 사실의 정확성, 신뢰성 등 그 내용에 관하여는 어떠한 책임을 부담하지 아니하고,  회원은 자기의 책임아래 서비스를 이용하며, 서비스를 이용하여 게시 또는 전송한 자료 등에 관하여 손해가 발생하거나 자료의 취사 선택, 기타서비스 이용과 관련하여 어떠한 불이익이 발생 하더라도 이에 대한 모든 책임은 회원에게 있습니다.\n" +
                        "\n" +
                        "2.'갑'은 제12조의 규정에 위반하여 회원간 또는 회원과 제3자간에 서비스를 매개로 하여 물품거래 등과 관련하여 어떠한 책임도 부담하지 아니하고, 회원이 서비스의 이용과 관련하여 기대하는 이익에 관하여 책임을 부담하지 않습니다. \n" +
                        "\n" +
                        "3.회원 아이디(ID)와 비밀번호의 관리 및 이용상의 부주의로 인하여 발생 되는 손해 또는 제3자에 의한 부정사용 등에 대한 책임은 모두 회원에게 있습니다.\n" +
                        "\n" +
                        "4.회원이 제12조, 기타 이 약관의 규정을 위반함으로 인하여 '갑'이 회원 또는 제3자에 대하여 책임을 부담하게 되고, 이로써 '갑'에게 손해가 발생하게 되는 경우, 이 약관을 위반한 회원은 '갑'에게  발생하는 모든 손해를 배상하여야 하며, 동 손해로부터 '갑'을 면책시켜야 합니다.\n" +
                        "\n" +
                        "\n" +
                        "\n" +
                        "\n" +
                        "제18조 (분쟁의 해결) \n" +
                        "\n" +
                        "1.'갑'과 회원은 서비스와 관련하여 발생한 분쟁을 원만하게 해결하기 위하여 필요한 모든 노력을 하여야 합니다.\n" +
                        "\n" +
                        "2.1항의 규정에도 불구하고 분쟁으로 인하여 소송이 제기될 경우 소송은 '갑'의 소재지를 관할하는 법원의 관할로 합니다.\n");
                terms.setPositiveButton("확인", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int id)
                    {
                    }
                });
                terms.setNegativeButton("취소", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int id)
                    {
                    }
                });
                AlertDialog alertDialog1 = terms.create();
                alertDialog1.show();
                break;
            case R.id.appVer:
                Toast.makeText(this, "현재 버전 : WannaBe It(ver.1.3.2)\n 최신 업데이트 날짜 : 22/05/06",
                        Toast.LENGTH_LONG).show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public void onClick(View v) {


    }
}