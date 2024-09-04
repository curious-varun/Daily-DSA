class Solution:
    def robotSim(self, commands: List[int], obstacles: List[List[int]]) -> int:

        maxdistance = 0
        position = [ 0,0,deque([ "N","E","S","W" ])]
        hm = {( x,y ):True for x,y in obstacles }

        hm["N"] = lambda position : ( position[0],position[1] +1 )
        hm["S"] = lambda position : ( position[0],position[1] -1 )
        hm["E"] = lambda position : ( position[0] +1,position[1] )
        hm["W"] = lambda position : ( position[0] -1,position[1] )
        hm[-2]  = lambda position : position[2].appendleft(position[2].pop())
        hm[-1]  = lambda position : position[2].append(position[2].popleft())

        for command in commands:

            if  command <0 : hm[command](position)
            else:

                for _ in range(1,command +1):
                    X,Y = hm[position[2][0]](position)

                    if  hm.get(( X,Y )): break
                    else:
                        position[0] = X
                        position[1] = Y

                maxdistance = max(maxdistance, (position[0] **2) + (position[1] **2))
        return  maxdistance
