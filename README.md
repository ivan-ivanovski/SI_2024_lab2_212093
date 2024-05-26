### Лабораториска вежба бр.2 Софтверско Инженерство
## Иван Ивановски 212093
### Одговор на прашања од вежба се подолу
### Control Flow Graph
<img src="./SI_2024_lab2_resenie_CFG.PNG" alt="Slika na control flow graph na funckijata checkCart"/>
###  Цикломатска комплексност
За да пресметаме цикломатската комплексност на дадената функција, треба прво да идентификуваме јазлите и ребрата во контролниот токовен граф (CFG) на функцијата.<br> 
Потоа можеме да го примениме следниот израз за пресметување на цикломатската комплексност:<br>
V(G)=E−N+2<br>
Каде што:<br>
<ul>
<li>V(G) е цикломатската комплексност,</li>
<li>E е бројот на ребра (линии на кодот)</li>
<li>N е бројот на темиња (основни блокови или точки на одлука).</li> 
</ul>
Па според горе прикажаниот граф имаме 24 темиња, 32 ребра па од тука цикломатската комплексност ќе биде: V(G)=32-24+2=34-24=10.<br> 
Значи графот има цикломатска комплексност 10.
### Тестирање според every branch критериум
Следнава слика се однесува за тест случаи.Со секој тест случај се тестирање парче од код, линија по линија притао истиот тест да биде задоволен.
<img src="SI_2024_lab2_every_branch_testiranje.PNG" alt="Mesto od slika so test slucai po every branch kriterium"/>





