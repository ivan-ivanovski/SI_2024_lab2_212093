<h3>Лабораториска вежба бр.2 Софтверско Инженерство</h3>
<h3> Иван Ивановски 212093</h3>
<h4>Одговор на прашања од вежба се подолу</h4>
<h3>Control Flow Graph</h3>
<img src="./SI_2024_lab2_resenie_CFG.PNG" alt="Slika na control flow graph na funckijata checkCart"/>
<h3>Цикломатска комплексност</h3>
<p>За да пресметаме цикломатската комплексност на дадената функција, треба прво да идентификуваме јазлите и ребрата во контролниот токовен граф (CFG) на функцијата.
Потоа можеме да го примениме следниот израз за пресметување на цикломатската комплексност:
V(G)=E−N+2. Каде што:</p>
<ul>
<li>V(G) е цикломатската комплексност,</li>
<li>E е бројот на ребра (линии на кодот)</li>
<li>N е бројот на темиња (основни блокови или точки на одлука).</li> 
</ul>
<p>Па според горе прикажаниот граф имаме 24 темиња, 32 ребра па од тука цикломатската комплексност ќе биде: V(G)=32-24+2=34-24=10.</p> 
<p>Значи графот има цикломатска комплексност 10.</p>
<h3>Тестирање според every branch критериум</h3>
<p>Следнава слика се однесува за тест случаи.Со секој тест случај се тестирање парче од код, линија по линија притао истиот тест да биде задоволен.</p>
<img src="SI_2024_lab2_every_branch_testiranje.PNG" alt="Mesto od slika so test slucai po every branch kriterium"/>
<h3>Тестирање случаи по Multiple Condition критериум</h3>
<p>За напишување на тест случаи според Multiple Condition критериумот, треба да ги разгледаме сите можни комбинации на условите. Во конкретниот услов:</p>
<code>
(item.getPrice() > 300 && item.getDiscount() > 0 && item.getBarcode().charAt(0) == '0')
</code>
