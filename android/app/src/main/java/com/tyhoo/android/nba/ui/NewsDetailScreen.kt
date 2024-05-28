package com.tyhoo.android.nba.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.text.HtmlCompat
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.tyhoo.android.nba.data.NewsDetailData
import com.tyhoo.android.nba.viewmodel.NewsDetailViewModel

@Composable
fun NewsDetailScreen(
    modifier: Modifier = Modifier,
    viewModel: NewsDetailViewModel = hiltViewModel()
) {
    val newsDetail by viewModel.newsDetail.observeAsState()
    NewsDetailScreen(modifier, newsDetail)
}

@Composable
fun NewsDetailScreen(
    modifier: Modifier = Modifier,
    newsDetailData: NewsDetailData?
) {
    LazyColumn(modifier = modifier.padding(8.dp)) {
        item {
            newsDetailData?.let { data ->
                Text(
                    text = data.title,
                    style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold)
                )

                AsyncImage(
                    model = data.thumbnail2x,
                    contentDescription = data.title,
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(1F)
                        .padding(top = 8.dp),
                    contentScale = ContentScale.Crop
                )

                val content = HtmlCompat.fromHtml(data.cntHtml, HtmlCompat.FROM_HTML_MODE_COMPACT)
                Text(
                    text = content.toString(),
                    style = TextStyle(fontSize = 14.sp),
                    modifier = Modifier.padding(top = 8.dp)
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewNewsDetailScreen() {
    val news = NewsDetailData(
        "ESPN盘点今夏20大自由球员：詹姆斯当仁不让位居榜首",
        "https://img.nba.cn/image/nms/cms/2c40cac8-7a4b-4691-a4d3-b941e7b20583/j.jpg?auth_key=1716886200-1716886200-0-eda67c4ebab68756d5755f842f04232d&cdn_provider=110&ver=0.1.6",
        "2024-05-28 13:59:38",
        "<P><!--IMG_0--></P><P>虽然近年来NBA自由市场的球星效应有所减弱，但在今夏自由球员名单里，联盟历史得分王毫无疑问会成为焦点。如果勒布朗-<a href=\\\"https://china.nba.cn/player/2544\\\" target=\\\"_blank\\\" rel=\\\"noopener\\\">詹姆斯</a>拒绝执行2024-25赛季5140万美元的球员选项，那么他将自2018年以自由球员身份加盟湖人以来，首次成为不受限制的自由球员。</P><P>还有一些顶级球星，例如两届NBA总决赛MVP得主科怀-伦纳德，已经在本赛季与球队完成续约，将自己排除在自由球员名单之外，但队友保罗-<a href=\\\"https://china.nba.cn/player/202331\\\" target=\\\"_blank\\\" rel=\\\"noopener\\\">乔治</a>的去留依然尚未可知。</P><P>签约自由球员并不是打造目前仍在季后赛存活球队的关键因素，但却是尼克斯成为有力竞争者的重要途径。去年夏天，他们签下前金州勇士后卫唐特-迪温琴佐，并见证了他与同为自由球员加盟球队的杰伦-布伦森一同演绎职业生涯最佳赛季。</P><P>ESPN数据专家Kevin Pelton利用SCHOENE球员预测模型盘点了今夏20大自由球员，该模型根据球员过去三个赛季的表现以及历史上相似年龄球员发展轨迹进行预测，詹姆斯当仁不让位居榜首——</P><P><span style=\\\"font-size: 14pt;\\\"><strong>1.勒布朗-詹姆斯</strong></span></P><P>洛杉矶湖人 前锋 球员选项</P><P>预测贡献值：24.4</P><P>对于将在12月就年满40岁的詹姆斯来说，对未来三年进行预测实在有些夸张。而且在某种程度上，詹姆斯想打多久会比他能打多好更重要。尽管如此，鉴于他本赛季入选了最佳二阵，如果保持健康状态的话，他依然是这份名单中最出色的球员，而且明年之后依旧可以继续发挥价值。</P><P><!--IMG_1--></P><P><span style=\\\"font-size: 14pt;\\\"><strong>2.保罗-乔治</strong></span></P><P>洛杉矶快船 前锋/后卫 球员选项</P><P>预测贡献值：23.3</P><P>由于乔治的打球风格更依赖于身体技能，预计他在未来三个赛季的价值损失会比詹姆斯更大。尽管如此，如果离开快船，乔治将成为自2019年以来换队球员中预测值最高的球员。难怪ESPN记者Brian Windhorst在本月早些时候的报道称，乔治是76人今夏自由市场的首选目标，因为后者拥有顶薪以上的薪金空间，可以围绕他们的核心建队。</P><P><span style=\\\"font-size: 14pt;\\\"><strong>3.泰雷塞-马克西</strong></span></P><P>费城76人 后卫 受限制自由球员</P><P>预测贡献值：21.6</P><P>76人之所以在引进顶级自由球员方面拥有得天独厚的优势，是因为马克西价值1300万美元的廉价工资帽，这比他作为受限制自由球员可能获得的25%顶薪要便宜得多。马克西在23岁就已成长为全明星球员，预计三年后他的排名将仅次于詹姆斯。76人今夏可以在自由市场上寻找另一名球星，然后以超级顶薪与马克西续签一份长期合同。</P><P><span style=\\\"font-size: 14pt;\\\"><strong>4.伊曼纽尔-奎克利</strong></span></P><P>多伦多猛龙 后卫 受限制自由球员</P><P>预测贡献值：20.9</P><P>奎克利的预测排名也很高，他是马克西在肯塔基大学的后场搭档，同样刚刚结束新秀合同。猛龙在将OG-阿努诺比送至尼克斯的交易中得到了奎克利，在为猛龙出战的38场比赛中，他场均得到18.6分6.8助攻。可以预见的是，奎克利在扮演更大角色时效率会下降，但鉴于到6月才年满25岁，他可能还有更大的发展空间。</P><P><!--IMG_2--></P><P><span style=\\\"font-size: 14pt;\\\"><strong>5.詹姆斯-</strong></span><a href=\\\"https://china.nba.cn/player/201935\\\" target=\\\"_blank\\\" rel=\\\"noopener\\\">哈登</a></P><P>洛杉矶快船 后卫 非受限自由球员</P><P>预测贡献值：18.4</P><P>一年前，哈登在这份名单上高居第二，但他当时拒绝了球员选项并要求交易，最终被送到了快船。下一个三年后，哈登就已经37岁了，虽然他在24-25赛季的预测值在自由球员中排名第三，但到了26-27赛季，排名就下降到了第11位。</P><P><span style=\\\"font-size: 14pt;\\\"><strong>6.德安东尼-梅尔顿</strong></span></P><P>费城76人 后卫 非受限自由球员</P><P>预测贡献值：17.2</P><P>梅尔顿持续受背部伤病影响，再加上当家球星乔尔-恩比德缺阵，让76人这个赛季早早出局。在梅尔顿首发的33场比赛中，76人取得了22胜11负的战绩，但他在1月12日之后只出战了6场比赛。在健康的情况下，梅尔顿是贡献值方面的佼佼者，因为他防守全面，三分球命中率高（职业生涯37%）。而且梅尔顿才年满26岁，正值当打之年。</P><P><span style=\\\"font-size: 14pt;\\\"><strong>7.帕斯卡尔-西亚卡姆</strong></span></P><P>印第安纳步行者 前锋 非受限自由球员</P><P>预测贡献值：16.6</P><P>赛季中期，西亚卡姆加盟步行者与哈利伯顿并肩作战，帮助球队一路晋级东部决赛。展望未来，西亚卡姆可能会在下一份合同里有所损失，他在今年4月就已经年满30岁了，而同龄球员在接下来的赛季效率会明显下降。但尽管如此，西亚卡姆仍有望在未来几年成为一名高于平均水平的首发球员。</P><P><span style=\\\"font-size: 14pt;\\\"><strong>8.OG-阿努诺比</strong></span></P><P>纽约尼克斯 前锋 球员选项</P><P>预测贡献值：13.8</P><P>阿努诺比在攻防两端稳如磐石的表现可能无法用数据来体现。在12月底加盟尼克斯后，他为球队带来的影响显而易见。本赛季，尼克斯在阿努诺比登场时取得了20胜3负的战绩，并在季后赛开局取得6胜2负。</P><P><!--IMG_3--></P><P><span style=\\\"font-size: 14pt;\\\"><strong>9.德马尔-德罗赞</strong></span></P><P>芝加哥公牛 前锋 非受限自由球员</P><P>预测贡献值：13.8</P><P>这个排名证明了德罗赞很好地化解了年龄增长的影响，他现在的预测值比三年前他进入自由球员市场并通过先签后换加盟公牛时更好。在此期间，德罗赞两次入选全明星，并在本赛季获得年度最佳抢断球员奖的第二名。但在某种程度上，德罗赞也会被年龄拖累，因为在本赛季场均出场时间领跑NBA的他，将在今年夏天年满35岁。因此，现在选择在他身上下注的球队只能风险自负。</P><P><span style=\\\"font-size: 14pt;\\\"><strong>10.马利克-蒙克</strong></span></P><P>萨克拉门托国王 后卫 非受限自由球员</P><P>预测贡献值：12.6</P><P>蒙克本赛季场均出战26分钟，贡献职业生涯最高的15.4分5.1助攻，是年度最佳第六人的热门人选。但他因右膝内侧副韧带扭伤提前赛季报销，国王也因此无缘季后赛。过去的四个夏天，这是蒙克第三次成为自由球员，但26岁的他刚刚步入当打之年，被视为其他球队的引援目标，他们乐于试探国王是否愿意为重新签下蒙克而支付奢侈税。</P><P><span style=\\\"font-size: 14pt;\\\"><strong>11.尼古拉斯-克拉克斯顿</strong></span></P><P>布鲁克林篮网 中锋 非受限自由球员</P><P>预测贡献值：12.1</P><P>克拉克斯顿的价值更多地建立在他的弹跳能力和速度上，而不是他的技术，因此我们有可能在他25岁时已经看到了他的巅峰水平。尽管如此，作为一名优质的首发中锋，克拉克斯顿在他的下一份合同期内仍会尽力保持自己的身价。</P><P><span style=\\\"font-size: 14pt;\\\"><strong>12.托拜厄斯-哈里斯</strong></span></P><P>费城76人 前锋 非受限自由球员</P><P>预测贡献值：11.9</P><P>根据哈里斯在2019年夏天与76人签下的5年1.8亿美元合同来评估，他的表现确实差强人意。这一次，哈里斯可能会签下一份更适合的合同，他依旧是一名不俗的三分射手（职业生涯三分命中率37%），还能自主进攻。</P><P><span style=\\\"font-size: 14pt;\\\"><strong>13.小加里-特伦特</strong></span></P><P>多伦多猛龙 后卫 非受限自由球员</P><P>预测贡献值：11.8</P><P>在执行了23-24赛季1860万美元的球员选项后，小特伦特的表现下降至20-21赛季以来的最低点，场均28.1分钟得到13.7分。但25岁的小特伦特几乎没有任何潜在能力下降的迹象，这让他成为了下赛季有望反弹的球员之一。</P><P><span style=\\\"font-size: 14pt;\\\"><strong>14.加里-佩顿二世</strong></span></P><P>金州勇士 后卫/前锋 球员选项</P><P>预测贡献值：11.8</P><P>在帮助勇士夺得2022年NBA总冠军后，小佩顿以非受限自由球员身份签约开拓者，但在此后的两个赛季里，他受到伤病困扰仅出战66场比赛。根据数据统计显示，在勇士上赛季常规赛阶段，小佩顿在场时球队净胜分高居所有球员第二，仅次于新秀波齐姆斯基。虽然小佩顿拥有910万美元的球员选项，但他在赛季结束采访时表示，他乐于跳出球员选项并与球队重新签下长约，这样可以通过减少24-25赛季的薪水来削减勇士的奢侈税账单。</P><P><!--IMG_4--></P><P><span style=\\\"font-size: 14pt;\\\"><strong>15.丹吉洛-</strong></span><a href=\\\"https://china.nba.cn/player/1626156\\\" target=\\\"_blank\\\" rel=\\\"noopener\\\">拉塞尔</a></P><P>洛杉矶湖人 后卫 球员选项</P><P>预测贡献值：11.6</P><P>拉塞尔对于24-25赛季1870万美元球员选项的决定，将对今年夏天产生重要影响。他在下半程表现出色，三分球命中率达到职业生涯新高的41.5%。但在掘金首轮横扫湖人的系列赛中，拉塞尔的表现再次下滑，期间他的三分球命中率只有32%。如果拉塞尔执行球员选项，湖人就更容易将他交易出去以追逐其他明星球员，但如果他选择试水自由市场，那么球队将受困于薪资的灵活性，很难找到球员取代他。</P><P><span style=\\\"font-size: 14pt;\\\"><strong>16.迈尔斯-布里奇斯</strong></span></P><P>夏洛特黄蜂 前锋 非受限自由球员</P><P>预测贡献值：11.6</P><P>严格来说，布里奇斯是今夏最令人垂涎的自由球员之一。他是一名全能型前锋，在过去的两个赛季里，他场均得分都在20分以上。不过，布里奇斯因遭遇指控缺席了整个22-23赛季，同时在本赛季前10场比赛依旧被NBA禁赛。布里奇斯去年接受的是790万美元的资质报价，而他将在今年成为非受限自由球员。</P><P><span style=\\\"font-size: 14pt;\\\"><strong>17.巴迪-希尔德</strong></span></P><P>费城76人 后卫 非受限自由球员</P><P>预测贡献值：11.5</P><P>在过去五个赛季中，只有斯蒂芬-库里的三分球命中数（1618）超过希尔德（1600），而其他球员和希尔德的差距都在260次以上。但这只是希尔德进攻端贡献的总和，而事实上他的手感总是时冷时热。跟随76人出战生涯首次季后赛期间，希尔德大部分时间都处于低迷状态，甚至跌至轮换末端。但之后在与尼克斯的G6中，他出战21分钟得到20分。考虑到投篮不如其他技能受年龄的影响更大，31岁的希尔德未来有望继续发光发热。</P><P><span style=\\\"font-size: 14pt;\\\"><strong>18.泰厄斯-琼斯</strong></span></P><P>华盛顿奇才 后卫 非受限自由球员</P><P>预测贡献值：11.2</P><P>琼斯职业生涯首次成为全职首发球员，场均12.0分7.3助攻，三分球命中率41%，均创下职业生涯新高，同时打破了自己保持的助攻失误比最佳纪录（7.35）。随着琼斯年龄接近三十，用速度来弥补体型上的不足可能会变得更加困难，这让他更有可能成为一名优秀的替补控卫，而不是一名优质的首发球员。</P><P><span style=\\\"font-size: 14pt;\\\"><strong>19.以赛亚-哈尔滕施泰因</strong></span></P><P>纽约尼克斯 中锋 非受限自由球员</P><P>预测贡献值：11.1</P><P>在米切尔-罗宾逊因左脚踝手术缺阵后，哈尔滕施泰因成为尼克斯的首发中锋，他延续了球队在进攻篮板上的统治力，并改善了内线防守。如果哈滕符合条件，他将有机会入选最佳防守阵容。根据统计数据显示，当哈滕作为主要防守者的五英尺范围内，对手的投篮命中率为52.5%，在每场比赛至少防守四次此类投篮的球员中排名前十。与去年925万美元的薪水相比，这样的表现应该能为哈滕赢得加薪。</P><P><!--IMG_5--></P><P><span style=\\\"font-size: 14pt;\\\"><strong>20.马克尔-富尔茨</strong></span></P><P>奥兰多魔术 后卫 非受限自由球员</P><P>预测贡献值：9.2</P><P>22-23赛季，富尔茨以场均14.0分5.7助攻的数据创造了职业生涯的最佳表现，而在上赛季的大部分时间里，他带领了魔术的第二阵容发挥出色。这位前状元秀可能非常适合担任替补角色，类似于另一位在伤病中挣扎的状元秀利文斯顿在勇士所扮演的角色。</P><P><span style=\\\"font-size: 14pt;\\\"><strong>其他值得关注的自由球员</strong></span></P><P>掘金的肯塔维奥斯-考德威尔-波普过去三个赛季的贡献值表现很高，在所有球员里排名第53。作为侧翼的重要防守者，这比他不够抢眼的场均数据更能反映他的价值。</P><P>勇士球星克莱-汤普森也遭遇了同样的困境。自从前十字韧带和跟腱受伤以来，汤普森已经不再是顶级的外线防守者了，34岁的年龄也让他的贡献值预测大打折扣。</P><P>值得一提的还有两名去年夏天被迫以老将底薪签约的球员，他们重新找回了自己的价值，独行侠的小德里克-琼斯和76人的凯利-乌布雷在今年的季后赛中均以首发球员身份出场。在76人对阵尼克斯的系列赛中，乌布雷一直负责防守布伦森，而小琼斯则是独行侠在西部决赛中的外线防守尖兵。</P>"
    )
    Box(modifier = Modifier.background(Color.White)) {
        NewsDetailScreen(newsDetailData = news)
    }
}