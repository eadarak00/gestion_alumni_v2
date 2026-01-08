import React, { useState, useEffect, useCallback } from 'react';
import LayoutMessagerie from '../../composants/messagerie/LayoutMessagerie';
import ListeConversations from '../../composants/messagerie/ListeConversations';
import FenetreChat from '../../composants/messagerie/FenetreChat';
import EntreeMessage from '../../composants/messagerie/EntreeMessage';
import { ServiceMessagerie } from '../../services/ServiceMessagerie';

const PageMessagerie = () => {
    const [conversations, setConversations] = useState([]);
    const [messages, setMessages] = useState([]);
    const [activeConversationId, setActiveConversationId] = useState(null);
    const [loadingConv, setLoadingConv] = useState(true);
    const [loadingMsg, setLoadingMsg] = useState(false);
    const [error, setError] = useState(null);
    const currentUserId = ServiceMessagerie.getCurrentUserId();

    // Charger les conversations au montage
    useEffect(() => {
        fetchConversations();
    }, []);

    // Recharger les messages quand on change de conversation
    useEffect(() => {
        if (activeConversationId) {
            fetchMessages(activeConversationId);
            markAsRead(activeConversationId);
        } else {
            setMessages([]);
        }
    }, [activeConversationId]);

    const fetchConversations = async () => {
        setLoadingConv(true);
        try {
            const data = await ServiceMessagerie.getConversations();
            setConversations(data);
        } catch (err) {
            setError("Impossible de charger les conversations.");
            console.error(err);
        } finally {
            setLoadingConv(false);
        }
    };

    const fetchMessages = async (id) => {
        setLoadingMsg(true);
        try {
            const data = await ServiceMessagerie.getMessages(id);
            setMessages(data);
        } catch (err) {
            console.error("Erreur chargement messages", err);
        } finally {
            setLoadingMsg(false);
        }
    };

    const markAsRead = async (id) => {
        await ServiceMessagerie.markAsRead(id);
        // Update local state to reflect read status
        setConversations(prev => prev.map(c =>
            c.id === id ? { ...c, unreadCount: 0, lastMessage: { ...c.lastMessage, read: true } } : c
        ));
    }

    const handleSendMessage = async (text) => {
        if (!activeConversationId) return;

        try {
            // Optimistic update for UI responsiveness
            const tempId = Date.now();
            const optimisticMsg = {
                id: tempId,
                senderId: currentUserId,
                text: text,
                timestamp: new Date().toISOString()
            };
            setMessages(prev => [...prev, optimisticMsg]);

            // Call service
            const sentMsg = await ServiceMessagerie.sendMessage(activeConversationId, text);

            // Replace optimistic msg with real one (if ID changed, though here it's similar)
            setMessages(prev => prev.map(m => m.id === tempId ? sentMsg : m));

            // Update conversation list order and preview
            fetchConversations();

        } catch (err) {
            setError("Erreur lors de l'envoi du message.");
            // Rollback optimistic update implementation skipped for brevity, but recommended in prod
        }
    };

    const activeConversation = conversations.find(c => c.id === activeConversationId);

    if (loadingConv && !conversations.length) {
        return (
            <div className="flex items-center justify-center h-screen bg-gray-50">
                <div className="animate-spin rounded-full h-12 w-12 border-b-2 border-emerald-600"></div>
            </div>
        );
    }

    return (
        <div className="h-screen flex flex-col">
            {/* Error Toast (Simple implementation) */}
            {error && (
                <div className="bg-red-100 border border-red-400 text-red-700 px-4 py-3 rounded relative text-center" role="alert">
                    <strong className="font-bold">Erreur: </strong>
                    <span className="block sm:inline">{error}</span>
                    <span className="absolute top-0 bottom-0 right-0 px-4 py-3" onClick={() => setError(null)}>
                        <svg className="fill-current h-6 w-6 text-red-500" role="button" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 20 20"><title>Close</title><path d="M14.348 14.849a1.2 1.2 0 0 1-1.697 0L10 11.819l-2.651 3.029a1.2 1.2 0 1 1-1.697-1.697l2.758-3.15-2.759-3.152a1.2 1.2 0 1 1 1.697-1.697L10 8.183l2.651-3.031a1.2 1.2 0 1 1 1.697 1.697l-2.758 3.152 2.758 3.15a1.2 1.2 0 0 1 0 1.698z" /></svg>
                    </span>
                </div>
            )}

            <LayoutMessagerie
                showSidebarMobile={!activeConversationId}
                sidebar={
                    <ListeConversations
                        conversations={conversations}
                        activeId={activeConversationId}
                        onSelectConversation={setActiveConversationId}
                    />
                }
                chat={
                    <div className="flex flex-col h-full">
                        <FenetreChat
                            conversation={activeConversation}
                            messages={messages}
                            currentUserId={currentUserId}
                            onBack={() => setActiveConversationId(null)}
                        />
                        {activeConversationId && (
                            <EntreeMessage onSendMessage={handleSendMessage} disabled={loadingMsg} />
                        )}
                    </div>
                }
            />
        </div>
    );
};

export default PageMessagerie;
