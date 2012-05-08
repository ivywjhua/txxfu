// bst to dual link


#include<stdio.h>

struct BSTreeNode
{
    int m_nValue;
    BSTreeNode *m_pLeft;
    BSTreeNode *m_pRight;
} ;

BSTreeNode* ConvertNode(BSTreeNode* pNode, bool asRight)
{
    if(!pNode)
    {
        return NULL;
    }

    BSTreeNode *pLeft = NULL;
    BSTreeNode *pRight = NULL;

    // left subtree exist, convert left subtree.
    if(pNode->m_pLeft)
    {
        pLeft = ConvertNode(pNode->m_pLeft, false);
    }

    // max left node link with pNode
    if(pLeft)
    {
        pLeft->m_pRight = pNode;
        pNode->m_pLeft = pLeft;
    }

    // right subtree exist, convert right subtree
    if(pNode->m_pRight)
    {
        pRight = ConvertNode(pNode->m_pRight, true);
    }

    // min right node link with pNode
    if(pRight)
    {
        pRight->m_pLeft = pNode;
        pNode->m_pRight = pRight;
    }

    BSTreeNode *pTemp = pNode;
    if(asRight)
    {
        // find min tree node for right tree
        while(pTemp->m_pLeft)
        {
            pTemp = pTemp->m_pLeft;
        }
    }
    else
    {
        // find max tree node for left tree
        while(pTemp->m_pRight)
        {
            pTemp = pTemp->m_pRight;
        }
    }
    
    return pTemp;
}

void ConvertNode2(BSTreeNode* pNode, BSTreeNode* pLastNodeInList)
{
    if(pNode == NULL)
    {
        return;
    }

    BSTreeNode* pCurrent = pNode;
    if(pCurrent->m_pLeft != NULL)
    {
        ConvertNode2(pCurrent->m_pLeft, pLastNodeInList);
    }

    pCurrent->m_pLeft = pLastNodeInList;
    if(pLastNodeInList != NULL)
    {
        pLastNodeInList->m_pRight = pCurrent;
    }

    pLastNodeInList = pCurrent;

    if(pCurrent->m_pRight != NULL)
    {
        ConvertNode2(pCurrent->m_pRight, pLastNodeInList);
    }
}

BSTreeNode* Convert2(BSTreeNode* pHeadOfTree)
{
    BSTreeNode *pLastNodeInList = NULL;
    ConvertNode2(pHeadOfTree, pLastNodeInList);

    BSTreeNode *pHeadOfList = pLastNodeInList;
    while(pHeadOfList && pHeadOfList->m_pLeft)
    {
        pHeadOfList = pHeadOfList->m_pLeft;
    }
    return pHeadOfList;
}


BSTreeNode* Convert(BSTreeNode* pHeadOfTree)
{
    return ConvertNode(pHeadOfTree, true);
}

void printLinkList(BSTreeNode* pTemp)
{
    BSTreeNode* pMark; 
    while(pTemp){
        printf("%d\n",pTemp->m_nValue);
        pTemp = pTemp->m_pRight;
        if(pTemp)
        {
            pMark = pTemp;
        }
    }

    pTemp = pMark;
    while(pTemp){
        printf("%d\n", pTemp->m_nValue);
        pTemp = pTemp->m_pLeft;
    }
}


int main(int argv, char *argc[])
{
    printf("Hello World\n");

    BSTreeNode p1, p2, p3, p4, p5;
    p1.m_nValue = 10;
    p2.m_nValue = 5;
    p3.m_nValue = 15;
    p4.m_nValue = 8;
    p5.m_nValue = 12;

    p1.m_pLeft = &p2;
    p1.m_pRight = &p3;
    p2.m_pLeft = NULL;
    p2.m_pRight = &p4;
    p3.m_pLeft = &p5;
    p3.m_pRight = NULL;

    p4.m_pLeft = NULL;
    p4.m_pRight = NULL;
    p5.m_pLeft = NULL;
    p5.m_pRight = NULL;

    BSTreeNode* pTemp = Convert2(&p1);
    printLinkList(pTemp);

    printf("Hello World\n");

    return 0;
}


