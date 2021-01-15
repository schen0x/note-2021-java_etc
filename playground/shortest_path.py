
while true:
    for (i = 0; i < nPoint; i++):
        if (!pFixed[i]):
            continue
        
        for (j = i + 1, j < nPoint, j++):
            if ( !pFixed[j] && pDist[j] < pDist[i]):
                i = j ## continue to i = j

        sPoint = i

        pFixed[sPoint] = true
        for (j = 0; j < nPoint; j++):
            if ( j.adjTo(sPoint) && !pFixed[j]):
                newDist = pDist[sPoint] + Distance[sPoint][j];
                if (newDist < pDist[j]):
                    pDist[j] = newDist;
                    pRoute[j] = sPoint





